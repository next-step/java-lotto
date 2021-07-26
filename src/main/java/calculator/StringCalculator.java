package calculator;

import java.util.Objects;

public class StringCalculator {
    private static final String SPLIT_TOKEN = ",|:";
    private static final String CUSTOM_SPLIT_TOKEN = "//(.)\n(.*)";


    public static int splitAndSum(String text) {
        if(nullOrEmpty(text)) {
            return 0;
        }

        return 1;
    }

    private static boolean nullOrEmpty(String text) {
        if(Objects.isNull(text) || text.equals("")) {
            return true;
        }
        return false;
    }
}
