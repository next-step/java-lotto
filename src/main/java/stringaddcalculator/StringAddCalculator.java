package stringaddcalculator;

import stringaddcalculator.util.StringUtil;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DELIMITER = ",|:";

    public static int splitAndSum(String expression) {

        if(StringUtil.isBlank(expression)){
            return 0;
        }

        return Arrays.stream(expression.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .reduce(0, (total, number) -> total + number)
                ;
    }
}
