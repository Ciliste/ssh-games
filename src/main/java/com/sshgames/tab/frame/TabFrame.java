package com.sshgames.tab.frame;

public interface TabFrame {
    
    public abstract char getUpperLeft ();
    public abstract char getUpperRight();
    public abstract char getLowerLeft ();
    public abstract char getLowerRight();

    public abstract String getUpperPattern();
    public abstract String getLowerPattern();
    public abstract String getLeftPattern ();
    public abstract String getRightPattern();
}