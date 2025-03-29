package StringCalculator.domain;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    public static int calculate(List<Operand> operands, List<Operator> operators) {
        int result = operands.get(0).getValue();
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            int operandValue = operands.get(i + 1).getValue();
            result = operator.apply(result, operandValue);
        }
        return result;
    }
}
