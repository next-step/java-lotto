package step1;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        return splitAndSum(Formula.valueOf(input));
    }

    public static int splitAndSum(Formula formula) {
        if (formula.isBlank()) {
            return Operand.ZERO_VALUE;
        }

        Integer[] tokens = Splitter.split(formula);

        return Arrays.stream(tokens)
                .reduce(0, Integer::sum);
    }
}
