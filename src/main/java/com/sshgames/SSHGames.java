package com.sshgames;

import java.net.PasswordAuthentication;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.sshd.common.NamedFactory;
import org.apache.sshd.common.file.virtualfs.VirtualFileSystemFactory;
import org.apache.sshd.common.keyprovider.KeyPairProvider;
import org.apache.sshd.common.session.SessionContext;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.auth.UserAuth;
import org.apache.sshd.server.auth.UserAuthFactory;
import org.apache.sshd.server.auth.UserAuthNone;
import org.apache.sshd.server.auth.UserAuthNoneFactory;
import org.apache.sshd.server.auth.keyboard.KeyboardInteractiveAuthenticator;
import org.apache.sshd.server.auth.password.AcceptAllPasswordAuthenticator;
import org.apache.sshd.server.auth.password.PasswordAuthenticator;
import org.apache.sshd.server.auth.password.StaticPasswordAuthenticator;
import org.apache.sshd.server.command.Command;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.shell.InteractiveProcessShellFactory;
import org.apache.sshd.server.shell.ProcessShellFactory;
import org.apache.sshd.server.shell.ShellFactory;
import org.apache.sshd.sftp.server.SftpSubsystemFactory;

import com.sshgames.shell.GameShellFactory;

/**
 * Hello world!
 *
 */
public class SSHGames {

    public static void main(String[] args) {

        SshServer sshd = SshServer.setUpDefaultServer();
        sshd.setPort(22);
        sshd.setHost("localhost");
        
        sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(Paths.get("hostkey.ser")));
        sshd.setPublickeyAuthenticator((a,b,c) -> true);

        sshd.setHost("localhost");

        sshd.setShellFactory(new GameShellFactory());

        List<UserAuthFactory> userAuthFactories = new ArrayList<UserAuthFactory>();
        userAuthFactories.add(new UserAuthNoneFactory());
        sshd.setUserAuthFactories(userAuthFactories);

        try {
            
            sshd.start();

            System.out.println(sshd.isStarted()?"SSHD is Started":"Cant start the service");
            System.out.println("Host : " + sshd.getHost());
            System.out.println("Port : " + sshd.getPort());

            Thread.sleep(10000000);// Sleep for main thread
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }
}