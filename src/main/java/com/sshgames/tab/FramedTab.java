package com.sshgames.tab;

import com.sshgames.display.Display;
import com.sshgames.tab.frame.TabFrame;

public abstract class FramedTab implements Tab {
    
    private TabFrame frame;

    protected abstract String getDraw();

    @Override
    public String getScreen() {
        
        String draw = this.getDraw(), sRet = Character.toString(this.frame.getUpperLeft());
        String[] drawLines = draw.split("\n");

        int max = drawLines[0].length();
        for (int cpt = 1; cpt < drawLines.length; cpt++) {

            if (drawLines[cpt].length() > max) max = drawLines[cpt].length();
        }

        for (int cpt = 0; cpt < max; cpt++) {

            sRet += this.frame.getUpperPattern().charAt(0);
        } 

        sRet += this.frame.getUpperRight() + "\n";
        for (int cpt = 0; cpt < drawLines.length; cpt++) {

            sRet += String.format("%c%-" + max + "s%c\n", this.frame.getLeftPattern().charAt(0), drawLines[cpt], this.frame.getRightPattern().charAt(0));
            // System.out.println(String.format("%c %-" + max + "s %c\n", this.frame.getLeftPattern().charAt(0), drawLines[cpt], this.frame.getRightPattern().charAt(0)));
        }

        sRet += this.frame.getLowerLeft();
        for (int cpt = 0; cpt < max; cpt++) {

            sRet += this.frame.getLowerPattern().charAt(0);
        } 
        sRet += this.frame.getLowerRight();

        // for (String str : draw.split("\n")) {

        //     System.out.println(str);
        // }

        return sRet;
    }

    public void setFrame(TabFrame frame) {
        
        this.frame = frame;
    } 
}