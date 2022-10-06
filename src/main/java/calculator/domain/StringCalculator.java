package calculator.domain;


import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    
    public int calculate(String expression) {
        InputParser inputParser = new InputParser(expression);

        return execute(inputParser.parseOperand(), inputParser.parseOperator());
    }

    private int execute(List<Integer> operandList, List<String> operatorList) {
        int result = operandList.get(0);

        for (int i = 0; i < operatorList.size(); i++) {
            result = Operator.from(operatorList.get(i)).execute(result, operandList.get(i + 1));
        }
        return result;
    }
}
