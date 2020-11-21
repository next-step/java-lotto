package calculator;

import calculator.utils.IntegerUtils;
import calculator.utils.StringUtils;

import java.util.List;

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
