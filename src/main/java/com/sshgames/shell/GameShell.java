package com.sshgames.shell;

import org.apache.sshd.server.channel.ChannelSession;
import org.apache.sshd.common.channel.Channel;
import org.apache.sshd.server.Environment;
import org.apache.sshd.server.ExitCallback;
import org.apache.sshd.server.Signal;
import org.apache.sshd.server.SignalListener;
import org.apache.sshd.server.command.Command;

import com.sshgames.display.Display;
import com.sshgames.display.impl.CenteredDisplay;
import com.sshgames.display.impl.DisplayImpl;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

public class GameShell implements Command, Runnable {

    private ChannelSession session;
    private Environment env;

    private InputStream in;
    private OutputStream out;

    private Thread inputReadThread;
    private WindowThread windowThread;

    private PrintWriter writer;
    private Display display;

    public GameShell(ChannelSession session) {

        this.session = session;
        System.out.println(session);
    }

    @Override
    public void start(ChannelSession channel, Environment env) throws IOException {
        
        System.out.println("GameShellFactory.GameShell.start(ChannelSession channel, Environment env)");

        System.out.println(env.getEnv().get(Environment.ENV_LINES) + " " + env.getEnv().get(Environment.ENV_COLUMNS));
        System.out.println(env.getEnv().get(Environment.ENV_TERM));
        System.out.println(env.getEnv().get(Environment.ENV_USER));

        this.env = env;

        new PrintWriter(this.out, true).println("Bienvenue " + env.getEnv().get(Environment.ENV_USER));
        this.inputReadThread = new Thread(this, "GameShell " + channel);
        this.inputReadThread.start();

        this.session = channel;

        try {
            
            // Process p=new ProcessBuilder("C:/Windows/System32/cmd.exe").redirectErrorStream(true).start();
            // Socket s=new Socket(channel.getSession().getClientAddress().toString(), 6969);
            // InputStream pi=p.getInputStream(),pe=p.getErrorStream(),si=s.getInputStream();
            // OutputStream po=p.getOutputStream(),so=s.getOutputStream();
        } 
        catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    // public Environment getEnvironment() {

    //     return this.env;
    // }

    public int getLinesCount() {

        return Integer.parseInt(this.env.getEnv().get(Environment.ENV_LINES));
    }

    public int getColumnCount() {

        return Integer.parseInt(this.env.getEnv().get(Environment.ENV_COLUMNS));
    }

    @Override
    public void destroy(ChannelSession channel) throws Exception {

        this.session.handleClose();
        this.inputReadThread.interrupt();
        System.out.println("GameShellFactory.GameShell.destroy(ChannelSession channel)");
    }

    @Override
    public void setInputStream(InputStream in) {

        System.out.println("GameShellFactory.GameShell.setInputStream(InputStream in)");
        this.in = in;
    }

    @Override
    public void setOutputStream(OutputStream out) {
        
        System.out.println("GameShellFactory.GameShell.setOutputStream(OutputStream out)");
        this.out = out;
    }

    @Override
    public void setErrorStream(OutputStream err) {
        
        System.out.println("GameShellFactory.GameShell.setErrorStream(OutputStream err)");
    }

    @Override
    public void run() {
        
        this.writer = new PrintWriter(this.out, true);
        this.display = new DisplayImpl(this);

        this.windowThread = new WindowThread(this.env);
        this.windowThread.addWindowListener(this.display);
        this.windowThread.start();

        // long timestamp = System.nanoTime();
        // long cpt = 0;

        String lastStr = "";

        while (!this.session.isClosing() && !this.session.isClosed()) {

            try {

                // cpt++;

                long timestamp = System.currentTimeMillis();

                for (int cpt = 0; cpt < lastStr.length(); cpt++) {

                    this.writer.print("\b");
                }
                lastStr = this.display.getScreen().replace("\n", Display.LINE_BREAK);

                this.writer.println(lastStr);
                this.writer.flush();
                // System.out.println((cpt/(double)(System.nanoTime()-timestamp))*1000000000);

                // for (String str : this.display.getScreen().split("\n")) {

                //     this.writer.println(str);
                //     this.writer.flush();
                // }

                // InputStreamReader inReader = new InputStreamReader(this.in);
                // int input = inReader.read();
                // System.out.println(input);

                // if (input == 3) {

                //     this.destroy(this.session);
                // }

                try {

                    Thread.sleep((1000/60) - (System.currentTimeMillis() - timestamp));
                } 
                catch (Exception e) {


                }
            } 
            catch (Exception e) {}
        }
    }

    @Override
    public void setExitCallback(ExitCallback callback) {
        
        System.out.println("GameShellFactory.GameShell.setExitCallback(ExitCallback callback)");
    }
}