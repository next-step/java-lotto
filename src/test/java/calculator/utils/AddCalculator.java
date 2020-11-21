package calculator.utils;

import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

public class AddCalculator {

    public int calculate(String value) {
        if (StringUtils.isEmpty(value)) {
            return 0;
        }

        List<String> operands = StringUtils.splitString(value);

        return IntegerUtils.parsePositiveInt(operands).stream()
                .mapToInt(Integer::intValue)
                .sum();

    }

}
