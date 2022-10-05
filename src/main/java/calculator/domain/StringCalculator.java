package calculator.domain;


import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private final static String SEPARATOR = " ";
    
    public int calculate(String expression) {
        InputParser inputParser = new InputParser();
        List<String> elementsOfExpression = Arrays.asList(expression.split(SEPARATOR));

        return execute(inputParser.parseOperand(elementsOfExpression), inputParser.parseOperator(elementsOfExpression));
    }

    private int execute(List<Integer> operandList, List<String> operatorList) {
        int result = operandList.get(0);

        for (int i = 0; i < operatorList.size(); i++) {
            result = Operator.from(operatorList.get(i)).execute(result, operandList.get(i + 1));
        }
        return result;
    }
}
