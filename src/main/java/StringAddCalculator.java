import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if(StringUtils.isBlank(input)){
            return 0;
        }
        String[] tokens= getTokens(input);
        return add(tokens);
    }

    private static int add(String[] tokens) {
        int sum = 0;
        for (String token: tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    private static String[] getTokens(String input){
        Matcher m2 = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m2.find()) {
            String customDelimiter = m2.group(1);
            return m2.group(2).split(customDelimiter);
        }

        String pa = "([0-9 \\, \\: ])";
        if (Pattern.compile(pa).matcher(input).find())
            return input.split(",|:");
        return null;
    }
}
