package step1;

import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        return splitAndSum(Formula.valueOf(input));
    }

    public static int splitAndSum(Formula formula) {
        if (formula.isBlank()) {
            return Operand.ZERO_VALUE;
        }

        List<Operand> operands = Splitter.split(formula);

        return operands.stream()
                .map(Operand::toInt)
                .reduce(0, Integer::sum);
    }
}
