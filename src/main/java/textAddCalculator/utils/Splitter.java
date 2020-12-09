package textAddCalculator.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private final static String REGEX = ",|:";

    public static String[] split(String inputValue) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputValue);
        if(m.find()) {
            return m.group(2).split(m.group(1));
        }
        return inputValue.split(REGEX);
    }
}
