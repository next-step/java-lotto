package step1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

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

        checkTokens(tokens);

        return tokens;
    }
    private static int sumSplitedText(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }

    private static void checkTokens(String[] tokens) {
        Arrays.stream(tokens).forEach( token -> {
            if(Integer.parseInt(token) < 0) {
                throw new IllegalArgumentException("");
            }
        });
    }

    private static boolean checkTextNull(String text) {
        if (text == null || text.equals("")) {
            return true;
        }
        return false;
    }
}
