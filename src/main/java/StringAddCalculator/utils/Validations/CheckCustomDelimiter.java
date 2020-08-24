package StringAddCalculator.utils.Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCustomDelimiter {

    //Test  matcherTest 용
    public static String returnCustomDelimiter(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            //String[] tokens = m.group(2).split(customDelimiter);
            return customDelimiter;
        }
        return null;
    }

}
