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
        return Arrays.stream(numbers)
                .map(Number::of)
                .reduce(Number.ZERO, Number::plus)
                .getValue();
    }
}
