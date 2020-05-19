import number.Number;
import splitter.Splitter;
import splitter.SplitterManager;
import util.StringUtil;

import java.util.Arrays;

public class StringCalculator {

    public int calculate(final String value) {
        if (StringUtil.isEmpty(value)) {
            return Number.ZERO_VALUE;
        }
        Splitter splitter = SplitterManager.of().matchedSplitter(value);
        return sum(splitter.split(value));
    }

    private int sum(final String[] numbers) {
        if (this.isEmptyNumbers(numbers)) {
            return Number.ZERO_VALUE;
        }
        return Arrays.stream(numbers)
                .map(Number::of)
                .reduce(Number.ZERO, Number::plus)
                .getValue();
    }

    private boolean isEmptyNumbers(final String[] numbers) {
        if (numbers.length == 1) {
            return numbers[0].isEmpty();
        }
        return false;
    }
}
