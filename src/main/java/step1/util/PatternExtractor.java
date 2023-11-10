package step1.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExtractor {
    public static String extract(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find() ? matcher.group() : "";
    }


    public static List<String> extractAll(String input, String regex) {
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


    public static Stack<Integer> stack(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        Stack<Integer> result = new Stack<>();
        while(matcher.find()) {
            result.push(Integer.parseInt(matcher.group()));
        }
        return result;
    }

}
