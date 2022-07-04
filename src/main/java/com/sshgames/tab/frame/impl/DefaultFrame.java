package com.sshgames.tab.frame.impl;

import com.sshgames.tab.frame.TabFrame;

public class DefaultFrame implements TabFrame {

    @Override
    public char getUpperLeft() {
        
        return '╔';
    }

    @Override
    public char getUpperRight() {
        
        return '╗';
    }

    @Override
    public char getLowerLeft() {
        
        return '╚';
    }

    @Override
    public char getLowerRight() {
        
        return '╝';
    }

    @Override
    public String getUpperPattern() {
        
        return "═";
    }

    @Override
    public String getLowerPattern() {
        
        return "═";
    }

    @Override
    public String getLeftPattern() {
        
        return "|";
    }

    @Override
    public String getRightPattern() {
        
        return "║";
    }
}