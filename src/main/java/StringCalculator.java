import splitter.CommaAndColonSplitter;
import splitter.CustomSplitter;
import splitter.Splitter;
import util.StringUtil;

import java.util.Arrays;

public class StringCalculator {

    private static final int ZERO = 0;

    public int calculate(final String value) {
        if (StringUtil.isEmpty(value)) {
            return ZERO;
        }

        Splitter customSplitter = new CustomSplitter();
        if (customSplitter.support(value)) {
            return sum(customSplitter.split(value));
        }
        Splitter commaAndColonSplitter = new CommaAndColonSplitter();
        return sum(commaAndColonSplitter.split(value));
    }

    private int sum(final String[] numbers) {
//        validateIsBlank(numbers);
//        validateNegativeNumber(numbers);
        return Arrays.stream(numbers)
                .mapToInt(StringUtil::toInt)
                .sum();
    }
}
