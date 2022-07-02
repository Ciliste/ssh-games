package com.sshgames.display.impl;

import com.sshgames.display.Display;
import com.sshgames.shell.GameShell;
import com.sshgames.tab.Tab;

public class CenteredDisplay implements Display {

    private GameShell shell;

    private Tab currentTab;
    private Tab previousTab;

    public CenteredDisplay(GameShell shell) {

        this.shell = shell;
    }

    @Override
    public String getScreen() {
        
        String tab = this.currentTab.getScreen();

        return null;
    }

    @Override
    public void changeTab(Tab tab) {
        
        this.currentTab = tab;      
    }
}
