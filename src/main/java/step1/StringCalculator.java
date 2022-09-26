package step1;

import step1.operator.Operator;
import step1.operator.OperatorFactory;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int calculate(String text) {
        String[] parameters = text.split(" ");

        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        for (int i = 0; i < parameters.length; i++) {
            isNumeric(parameters[i], numbers, operators);
        }

        int result = 0;

        for (int i = 0; i < operators.size(); i++) {
            Operator operator = OperatorFactory.createOperator(operators.get(i));
            result = operator.calculate(numbers.get(i), numbers.get(i+1));
            numbers.set(i+1, result);
        }

        return result;
    }

    private static boolean isNumeric(String operand, List<Integer> numbers, List<String> operator){
        try {
            int number = Integer.parseInt(operand);
            numbers.add(number);
            return true;
        } catch (NumberFormatException numberFormatException) {
            operator.add(operand);
            return false;
        }
    }
}
