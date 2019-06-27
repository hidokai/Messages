package com.chase;

import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageParser {
    private static Pattern MessageType1 = Pattern.compile("^(\\w+) at (\\d+)p$");
    private static Pattern MessageType2 = Pattern.compile("^(\\d+) sales of (\\w+) at (\\d+)p$");
    private static Pattern MessageType3 = Pattern.compile("^(add|sub|mul) (\\d+)p (\\w+)$");

    public static Message parse(String message) {
        Matcher matcher;

        matcher = MessageType1.matcher(message);
        if (matcher.find())
            return new Message1(matcher.group(1), Integer.parseInt(matcher.group(2)));

        matcher = MessageType2.matcher(message);
        if (matcher.find())
            return new Message2(matcher.group(2), Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(3)));

        matcher = MessageType3.matcher(message);
        if (matcher.find())
            return new Message3(matcher.group(3), matcher.group(1), Integer.parseInt(matcher.group(2)));

        throw new InvalidParameterException("Invalid message");
    }
} 