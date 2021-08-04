package stringcalculator;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String s) {
        if (StringValidation.validNull(s)) {
            return 0;
        }
        if (StringValidation.validLength(s)) {
           return Integer.parseInt(s);
        }
        StringValidation.validNegative(StringParser.parser(s));

        return Arrays.stream(StringParser.parser(s)).sum();
    }

}
