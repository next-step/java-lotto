package study.calculator.domain;

import java.util.*;

public class StringAddition {
    public static int splitAndSum(String operandWithDelimiter) {
        if (Objects.isNull(operandWithDelimiter)) {
            return 0;
        }
        List<String> stringOperands = Splitter.split(operandWithDelimiter);

        List<Operand> operands = new ArrayList<>();
        for (String stringOperand : stringOperands) {
            operands.add(Operand.getInstance(stringOperand));
        }
        return Addition.sum(operands);
    }
}
