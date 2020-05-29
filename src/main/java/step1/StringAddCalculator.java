package step1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    public static int splitAndSum(String text) {

        if(textNullCheck(text)){
            return 0;
        }

        String[] tokens = text.split(",|:");

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens= m.group(2).split(customDelimiter);
        }

        checkTokens(tokens);

        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }

    private static void checkTokens(String[] tokens) {
        Arrays.stream(tokens).forEach( token -> {
            if(Integer.parseInt(token) < 0) {
                throw new RuntimeException("");
            }
        });
    }

    private static boolean textNullCheck(String text) {
        if (text == null || text.equals("")) {
            return true;
        }
        return false;
    }
}
