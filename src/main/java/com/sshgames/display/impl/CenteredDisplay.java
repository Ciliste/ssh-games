package com.sshgames.display.impl;

import com.sshgames.display.Display;
import com.sshgames.shell.GameShell;
import com.sshgames.tab.Tab;
import com.sshgames.tab.impl.LoginTab;

public class CenteredDisplay implements Display {

    private GameShell shell;

    private Tab currentTab;
    private Tab previousTab;

    public CenteredDisplay(GameShell shell) {

        this.currentTab = new LoginTab();
        
        this.shell = shell;
    }

    @Override
    public String getScreen() {
        
        // On récupère l'onglet
        String tab = this.currentTab.getScreen(), sRet = "";

        // On récupère les dimensions du Shell et de l'onglet
        int shellLines = this.shell.getLinesCount(), shellColumns = this.shell.getColumnCount();
        int tabLines = this.currentTab.getScreen().split("\n").length, tabColumns = this.currentTab.getScreen().split("\n")[0].length();

        for (int cpt = 0; cpt < (shellLines/2) - (tabLines/2); cpt++) {

            sRet += "\n";
        }

        String indent = "";
        for (int cpt = 0; cpt < (shellColumns/2) - (tabColumns/2); cpt++) {

            indent += " ";
        }

        for (String line : tab.split("\n")) {

            sRet += indent + line + "\n";
        }

        for (int cpt = 0; cpt < (shellLines/2) - (tabLines/2); cpt++) {

            sRet += "\n";
        }



        return sRet;
    }

    @Override
    public void addTab(Tab tab) {
        
        this.currentTab = tab;      
    }

    @Override
    public void windowResized(int rows, int columns) {
        // TODO Auto-generated method stub
        
    }
}
