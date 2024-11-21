package com.textprocessingtool.textutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtil {
    public static boolean match(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean matchFound = matcher.matches();
        return matchFound;
    }
}
