package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {

    private static final Pattern pattern = Pattern.compile("\\d");

    public static int process(String input) {
        if(isNullOrEmpty(input)) throw new IllegalArgumentException();
        String[] splitInput = input.split(" ");
        int result = 0;
        for(String str : splitInput){
            result = handle(result, str);
        }
        return result;
    }

    private static int handle(int result, String str) {
        if(isNumber(str)){
            result += Integer.parseInt(str);
        }
        return result;
    }

    private static boolean isNumber(String str) {
        return pattern.matcher(str).find();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || "".equals(input);
    }
}
