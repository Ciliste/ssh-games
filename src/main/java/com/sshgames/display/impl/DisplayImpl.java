package com.sshgames.display.impl;

import java.util.ArrayList;
import java.util.List;

import com.sshgames.display.Display;
import com.sshgames.shell.GameShell;
import com.sshgames.shell.WindowListener;
import com.sshgames.tab.Tab;

public class DisplayImpl implements Display {

    private List<Tab> tabs;
    private int rows, cols;

    private GameShell shell;

    public DisplayImpl(GameShell shell) {

        this.tabs = new ArrayList<Tab>();
        this.shell = shell;
    }

    @Override
    public String getScreen() {
        
        String sRet = "";
        for (int cptLig = 0; cptLig < this.rows; cptLig++) {

            for (int cptCol = 0; cptCol < this.cols; cptCol++) {

                sRet += "\033[37m" + "."; 
            }

            sRet += "\n";
        }


        return "test";
    }

    @Override
    public void addTab(Tab tab) {
        
        this.tabs.add(tab);
    }

    @Override
    public void windowResized(int rows, int columns) {

        System.out.println(rows + " " + columns);
        this.rows = rows; this.cols = columns;
    }
}
