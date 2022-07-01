package com.sshgames.shell;

import org.apache.sshd.server.channel.ChannelSession;
import org.apache.sshd.common.Factory;
import org.apache.sshd.common.channel.Channel;
import org.apache.sshd.common.channel.ChannelPipedInputStream;
import org.apache.sshd.common.util.io.IoUtils;
import org.apache.sshd.scp.server.InputStreamReader;
import org.apache.sshd.server.Environment;
import org.apache.sshd.server.ExitCallback;
import org.apache.sshd.server.Signal;
import org.apache.sshd.server.SignalListener;
import org.apache.sshd.server.command.Command;
import org.apache.sshd.server.shell.ShellFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameShellFactory implements ShellFactory {

    @Override
    public Command createShell(ChannelSession channel) throws IOException {
        
        System.out.println("GameShellFactory.createShell(ChannelSession channel)");

        System.out.println(channel.getRemoteWindow().getSize());

        return new GameShell(channel);
    }
}