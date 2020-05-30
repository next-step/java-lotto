package step1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
<<<<<<< HEAD
    public static int splitAndSum(String text) {

        if(textNullCheck(text)){
            return 0;
        }

        String[] tokens = text.split(",|:");
=======

    private static final String TEXT_SPLIT_REGX = ",|:";

    public static int splitAndSum(String text) {
        if(checkTextNull(text)){
            return 0;
        }

        String tokens[] = splitText(text);

        checkTokens(tokens);

        return sumSplitedText(tokens);
    }

    private static String[] splitText(String text) {

        String[] tokens = text.split(TEXT_SPLIT_REGX);
>>>>>>> step1bak

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens= m.group(2).split(customDelimiter);
        }

<<<<<<< HEAD
        checkTokens(tokens);

=======
        return tokens;
    }

    private static int sumSplitedText(String[] tokens) {
>>>>>>> step1bak
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }

    private static void checkTokens(String[] tokens) {
        Arrays.stream(tokens).forEach( token -> {
            if(Integer.parseInt(token) < 0) {
<<<<<<< HEAD
                throw new RuntimeException("");
=======
                throw new IllegalArgumentException("");
>>>>>>> step1bak
            }
        });
    }

<<<<<<< HEAD
    private static boolean textNullCheck(String text) {
=======
    private static boolean checkTextNull(String text) {
>>>>>>> step1bak
        if (text == null || text.equals("")) {
            return true;
        }
        return false;
    }
}
