package com.sshgames.display;

import com.sshgames.tab.Tab;

/* 
 * Interface principale d'affichage
*/
public interface Display {
    
    public abstract void fireScreenUpdate();

    public abstract String getScreen();

    public abstract void changeTab(Tab tab); 
}