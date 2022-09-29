package step1;

import step1.calculator.Calculator;
import step1.calculator.OperatorFactory;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private static final String OPERATOR_OPERAND_DELIMITER = " ";

    public static int calculate(String text) {
        String[] parameters = text.split(OPERATOR_OPERAND_DELIMITER);
        List<Integer> operands = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        for (int i = 0; i < parameters.length; i++) {
            distinguishOperandAndOperator(parameters[i], operands, operators);
        }

        return generateResult(operators, operands);
    }

    private static void distinguishOperandAndOperator(String operand, List<Integer> numbers, List<String> operator){
        try {
            int number = Integer.parseInt(operand);
            numbers.add(number);
        } catch (NumberFormatException numberFormatException) {
            operator.add(operand);
        }
    }

    private static int generateResult(List<String> operators, List<Integer> operand) {
        int result = 0;

        for (int i = 0; i < operators.size(); i++) {
            Calculator calculator = OperatorFactory.createCalculator(operators.get(i));
            result = calculator.calculate(operand.get(i), operand.get(i+1));
            operand.set(i+1, result);
        }

        return result;
    }
}
