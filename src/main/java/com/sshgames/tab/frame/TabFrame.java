package com.sshgames.tab.frame;

/**
 * Interface qui va gérer les contours d'un onglet 
 */
public interface TabFrame {
    
    /**
     * Retourne le caractère situé en haut à gauche du cadre
     * 
     * @return le caractère du coin
     */
    public abstract char getUpperLeft();

    /**
     * Retourne le caractère situé en haut à droite du cadre
     * 
     * @return le caractère du coin
     */
    public abstract char getUpperRight();

    /**
     * Retourne le caractère situé en bas à gauche du cadre
     * 
     * @return le caractère du coin
     */
    public abstract char getLowerLeft();

    /**
     * Retourne le caractère situé en bas à droite du cadre
     * 
     * @return le caractère du coin
     */
    public abstract char getLowerRight();

    /**
     * Retourne la chaîne qui forme le pattern du bord supérieur du cadre
     * 
     * @return la chaîne du pattern
     */
    public abstract String getUpperPattern();

    /**
     * Retourne la chaîne qui forme le pattern du bord inférieur du cadre
     * 
     * @return la chaîne du pattern
     */
    public abstract String getLowerPattern();

    /**
     * Retourne la chaîne qui forme le pattern du bord gauche du cadre
     * 
     * @return la chaîne du pattern
     */
    public abstract String getLeftPattern();

    /**
     * Retourne la chaîne qui forme le pattern du bord droit du cadre
     * 
     * @return la chaîne du pattern
     */
    public abstract String getRightPattern();
}