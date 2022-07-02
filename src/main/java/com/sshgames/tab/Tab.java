package com.sshgames.tab;

import com.sshgames.tab.frame.TabFrame;

public interface Tab {
    
    public abstract String getScreen();

    public abstract void setFrame(TabFrame frame);
}