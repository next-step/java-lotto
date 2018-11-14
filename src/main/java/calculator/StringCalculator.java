package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String INIT_DELIMETER = ",|:";

    public static int add(String text) {

        int sum = 0;

        if (text.isEmpty()) {
            return sum;
        }

        String[] values = ifCustomRegex(text);
        for (String value : values) {
            sum += Integer.parseInt(value);
        }

        return sum;
    }

    public static String[] ifCustomRegex(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] values = null;
        if(m.find()){
            String customDelimiter = m.group(1);
            values = m.group(2).split(customDelimiter);

        }
        return values;
    }

}

