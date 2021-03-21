package calculator;

import common.utils.StringUtils;

public class StringAddCalculator {

    public int calculate(String text) {
        if(StringUtils.isBlank(text)) {
            return 0;
        }
        PositiveNumbers positiveNumbers = new PositiveNumbers(text);
        return positiveNumbers.sum();
    }

}
