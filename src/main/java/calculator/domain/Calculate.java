package calculator.domain;

import java.util.List;

public class Calculate {

    public static int calculate(List<String> operands, List<String> operators) {
        int result = CalculationMethod.calculate(operators.get(0), operands.get(0), operands.get(1));
        for (int i = 1; i < (operators.size()); i++) {
            result = CalculationMethod.calculate(operators.get(i), String.valueOf(result), operands.get(i + 1));
        }
        return result;
    }
}
