package StringCalculator.domain;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATORS = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> {
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            }
    );

    public static int calculate(List<Operand> operands, List<Operator> operators) {
        int result = operands.get(0).getValue();
        for (int i = 0; i < operators.size(); i++) {
            String operatorSymbol = operators.get(i).getSymbol();
            int operandValue = operands.get(i + 1).getValue();
            result = OPERATORS.get(operatorSymbol).apply(result, operandValue);
        }
        return result;
    }
}
