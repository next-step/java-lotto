package calculator.domain;

import calculator.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class Calculator {

    private static final int ODD_EVEN_IDENTIFIER_NUMBER = 2;
    private static final int ODD_NUMBER = 1;
    private static final int EVEN_NUMBER = 0;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 0;
    private static final int THIRD_INDEX = 0;

    private static final String DELIMITER = " ";

    private static final List<String> operators = new ArrayList<>();
    private static final List<Integer> operands = new ArrayList<>();

    public static int calculate(String input) {
        inputValidateAndSplit(input);

        int result = 0;

        while (!operators.isEmpty()) {
            String operator = operators.get(FIRST_INDEX);
            operators.remove(FIRST_INDEX);


            result += Operator.execute(operator, operands.get(FIRST_INDEX), operands.get(SECOND_INDEX));
            operands.subList(FIRST_INDEX, THIRD_INDEX).clear();

            addResult(result);
        }

        return result;
    }

    private static void addResult(int result) {
        if (!operands.isEmpty()) {
            operands.add(FIRST_INDEX, result);
        }
    }

    public static void inputValidateAndSplit(String input) {
        StringUtils.isNullOrBlank(input);

        split(input.split(DELIMITER));
    }

    private static void split(String[] expressions) {
        for (int i = 0; i < expressions.length; i++) {
            addOperator(i, expressions[i]);
            addOperand(i, expressions[i]);
        }
    }

    private static void addOperator(int index, String expression) {
        if (isOdd(index)) {
            operators.add(expression);
        }
    }

    private static boolean isOdd(int index) {
        return index % ODD_EVEN_IDENTIFIER_NUMBER == ODD_NUMBER;
    }

    private static void addOperand(int index, String expression) {
        if (isEven(index)) {
           operands.add(Integer.parseInt(expression));
        }
    }

    private static boolean isEven(int index) {
        return index % ODD_EVEN_IDENTIFIER_NUMBER == EVEN_NUMBER;
    }
}
