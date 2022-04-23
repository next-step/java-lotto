package stringcalculator.domain;

import stringcalculator.enums.Operator;

public class StringCalculator {

    private StringCalculator() {
    }

    public static Integer calculate(String input) {
        String[] split = StringUtils.getStringArray(input);
        int precedingOperand = StringUtils.toInt(split, 0);

        for (int i = 1; i < split.length; i += 2) {
            int followingOperand = StringUtils.toInt(split, i + 1);
            precedingOperand = Operator.findOperator(split[i])
                    .operation(new Number(precedingOperand), new Number(followingOperand));
        }
        return precedingOperand;
    }
}