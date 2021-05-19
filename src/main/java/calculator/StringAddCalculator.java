package calculator;

import calculator.domain.Numbers;
import calculator.domain.Values;
import calculator.utils.StringUtils;

public class StringAddCalculator {

    public static int splitAndSum(final String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }

        Values values = Values.init(input);
        Numbers numbers = Numbers.from(values);
        return numbers.sum();
    }
}
