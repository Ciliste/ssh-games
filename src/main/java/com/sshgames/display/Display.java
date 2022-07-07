package com.sshgames.display;

import com.sshgames.shell.WindowListener;
import com.sshgames.tab.Tab;

/* 
 * Interface principale d'affichage
*/
public interface Display extends WindowListener {

    public static final String LINE_BREAK = System.getProperty("line.separator");

    /**
     * Fournit la String qui va finir sur le terminal du Client
     * 
     * @return la String à afficher
     */
    public abstract String getScreen();

    /**
     * Change l'onglet courrant
     * 
     * @param tab l'onglet sur lequel changer
     */
    public abstract void addTab(Tab tab); 
}