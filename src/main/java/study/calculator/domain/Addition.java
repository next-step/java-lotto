package study.calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Addition {
    public static int sum(Operand... operands) {
        return sum(Arrays.asList(operands));
    }

    public static int sum(List<Operand> operands) {
        int result = 0;

        for (Operand operand : operands) {
            result += operand.getOperand();
        }

        return result;
    }
}
