package com.sshgames.shell;

import java.util.ArrayList;
import java.util.List;

import org.apache.sshd.server.Environment;

public class WindowThread extends Thread {
    
    private List<WindowListener> lstWLis;
    private Environment env;
    private boolean running;

    public WindowThread(Environment env) {

        this.lstWLis = new ArrayList<WindowListener>();
        this.env = env;
    }

    @Override
    public void run() {

        this.running = true;

        int rows = Integer.parseInt(this.env.getEnv().get(Environment.ENV_LINES));
        int cols = Integer.parseInt(this.env.getEnv().get(Environment.ENV_COLUMNS));

        while (this.running) {

            if (rows != Integer.parseInt(this.env.getEnv().get(Environment.ENV_LINES)) || cols != Integer.parseInt(this.env.getEnv().get(Environment.ENV_COLUMNS))) {

                rows = Integer.parseInt(this.env.getEnv().get(Environment.ENV_LINES));
                cols = Integer.parseInt(this.env.getEnv().get(Environment.ENV_COLUMNS));
                for (WindowListener lis : this.lstWLis) {

                    lis.windowResized(rows, cols);
                }
            }
        }
    }

    public void addWindowListener(WindowListener lis) {

        this.lstWLis.add(lis);
    }
}   