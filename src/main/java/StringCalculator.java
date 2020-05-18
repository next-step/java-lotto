import splitter.CommaAndColonSplitter;
import util.StringUtil;

import java.util.Arrays;

public class StringCalculator {

    private static final int ZERO = 0;

    public int calculate(final String value) {
        if (StringUtil.isEmpty(value)) {
            return ZERO;
        }

        CommaAndColonSplitter commaAndColonSplitter = new CommaAndColonSplitter();
        String[] twoNumbers = commaAndColonSplitter.split(value);
        for (String number : twoNumbers) {
            isNegative(number);
        }

        return sum(twoNumbers);
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
