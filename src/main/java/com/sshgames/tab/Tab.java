package com.sshgames.tab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.sshgames.tab.frame.TabFrame;

public interface Tab {
    
    public static String open(File file) {

        try {

            return new String(Files.readAllBytes(file.toPath()));
        } 
        catch (Exception e) {

            return "Erreur...";
        }
    }

    public abstract String getScreen();
}