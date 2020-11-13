package calculator;

import calculator.utils.StringUtils;

import java.util.Arrays;

public class StringCalculator {
    public int sum(String expression) {
        if( StringUtils.isNullOrBlank(expression) ) return 0;

        String [] part = expression.split("[,:]");

        return Arrays.stream(part).map(Integer::valueOf).reduce(0, Integer::sum);
    }
}
