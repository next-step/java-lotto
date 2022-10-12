package calculator.domain;


import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    
    public int calculate(String expression) {
        InputParser inputParser = new InputParser(expression);

        return execute(inputParser.parseOperand(), inputParser.parseOperator());
    }

    private int execute(List<Integer> operands, List<String> operators) {
        int result = operands.get(0);

        for (int i = 0; i < operators.size(); i++) {
            result = Operator.from(operators.get(i)).execute(result, operands.get(i + 1));
        }
        return result;
    }
}
