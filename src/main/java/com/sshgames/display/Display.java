package com.sshgames.display;

import com.sshgames.tab.Tab;

/* 
 * Interface principale d'affichage
*/
public interface Display {

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
    public abstract void changeTab(Tab tab); 
}