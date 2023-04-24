package calculator.domain;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/]");
    private static final Pattern OPERAND_PATTERN = Pattern.compile("^\\d+$");

    private final Operators operators;
    private final Operands operands;

    public Calculator(Operators operators, Operands operands) {
        this.operators = operators;
        this.operands = operands;
    }

    public static Calculator of(List<String> expressions) {
        List<String> operators = validateOperator(expressions);
        List<String> operands = validateOperands(expressions);
        validateExpression(operators, operands);

        return new Calculator(Operators.of(operators), Operands.of(operands));
    }

    public int calculate() {
        return operands.getOperands().stream()
                .mapToInt(Operand::toInt)
                .reduce((x, y) -> operators.next().operate(x, y))
                .orElse(0);
    }

    private static List<String> validateOperator(List<String> input) {
         return input.stream()
                .filter(s -> OPERATOR_PATTERN.matcher(s).matches())
                .collect(Collectors.toList());
    }

    private static List<String> validateOperands(List<String> input) {
        return input.stream()
                .filter(s -> OPERAND_PATTERN.matcher(s).matches())
                .collect(Collectors.toList());
    }

    private static void validateExpression(List<String> operators, List<String> operands) {
        if(operators.isEmpty() || operands.isEmpty() || operators.size() != operands.size() - 1) {
            throw new IllegalArgumentException("Invalid Expression.");
        }
    }
}
