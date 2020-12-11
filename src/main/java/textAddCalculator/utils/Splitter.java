package textAddCalculator.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private final static String REGEX = ",|:";
    private static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    private Splitter() {
    }
  
    public static String[] split(String inputValue) {
        Matcher m = pattern.matcher(inputValue);
        if(m.find()) {
            return m.group(2).split(m.group(1));
        }
        return inputValue.split(REGEX);
    }
}
