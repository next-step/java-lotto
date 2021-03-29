package step1;

import step1.domain.Inputs;
import step1.domain.Numbers;
import step1.utils.StringUtils;

public class StringAddCalculator {

    public static int splitAndSum(final String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }
        Inputs inputs = Inputs.from(input);
        Numbers numbers = Numbers.from(inputs.getInputs());
        return numbers.sum();
    }
}
