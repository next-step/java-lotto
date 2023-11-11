package step1.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExtractor {
    public static String extract(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find() ? matcher.group() : "";
    }


    public static List<String> extractAllToList(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> result = new ArrayList<>();
        while(matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    public static boolean isMatch(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }


    public static LinkedList<Integer> extractAllToLinkedList(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        LinkedList<Integer> result = new LinkedList<>();
        while(matcher.find()) {
            result.add(Integer.parseInt(matcher.group()));
        }
        return result;
    }

}
