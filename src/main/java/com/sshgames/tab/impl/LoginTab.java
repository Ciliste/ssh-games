package com.sshgames.tab.impl;

import java.io.File;

import com.sshgames.display.Display;
import com.sshgames.tab.FramedTab;
import com.sshgames.tab.Tab;
import com.sshgames.tab.frame.impl.DefaultFrame;

public class LoginTab extends FramedTab {

    private static String TITLE = Tab.open(new File("C:/Users/theoa/Documents/Projets/ssh-games/assets/test.txt"));

    public LoginTab() {

        this.setFrame(new DefaultFrame());
    }

    @Override
    protected String getDraw() {
        
        try {

            for (String str : LoginTab.TITLE.split("\n")) {

                System.out.println(str);
            }

            return LoginTab.TITLE;
        } catch (Exception e) {
            //TODO: handle exception
        }
        return "Erreur...";
    }
}