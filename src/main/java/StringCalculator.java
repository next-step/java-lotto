import splitter.CommaAndColonSplitter;
import splitter.CustomSplitter;
import util.StringUtil;

import java.util.Arrays;

public class StringCalculator {

    private static final int ZERO = 0;

    public int calculate(final String value) {
        if (StringUtil.isEmpty(value)) {
            return ZERO;
        }

        CustomSplitter customSplitter = new CustomSplitter();
        if (customSplitter.isMatchedPattern(value)) {
            String[] numbers = customSplitter.split(value);
            for (String number : numbers) {
                isNegative(number);
            }
            return sum(numbers);
        }

        CommaAndColonSplitter commaAndColonSplitter = new CommaAndColonSplitter();
        String[] numbers = commaAndColonSplitter.split(value);
        for (String number : numbers) {
            isNegative(number);
        }
        return sum(numbers);
    }

    private int sum(final String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(StringUtil::toInt)
                .sum();
    }

    private void isNegative(final String value) {
        if (StringUtil.toInt(value) < ZERO) {
            throw new RuntimeException();
        }
    }
}
