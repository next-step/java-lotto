package step1;

import java.util.*;
import java.util.function.BiFunction;

public class Calculator {

    private static final String BLACK_STRING = " ";

    private List<Integer> numbers = new ArrayList<>();
    private List<BiFunction> operators = new ArrayList<>();

    public Calculator(String input) {
        initCalculator(input);
    }

    private void initCalculator(String input) {
        checkNullOrBlank(input);
        String[] inputArr = spiltInput(input);
        checkValidExpression(inputArr);

        numbers = getNumbers(inputArr);
        operators = getOperators(inputArr);
    }

    private void checkValidExpression(String[] inputArr) {
        if (inputArr.length % 2 == 0) {
            throw new IllegalArgumentException("식이 올바르지 않습니다");
        }
    }

    private void checkNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null 이거나 빈 값입니다");
        }
    }

    private List<BiFunction> getOperators(String[] inputArr) {
        for (int i = 1; i < inputArr.length; i += 2) {
            addOperator(inputArr[i]);
        }
        return operators;
    }

    private List<Integer> getNumbers(String[] inputArr) {
        for (int i = 0; i < inputArr.length; i += 2) {
            addNumber(inputArr[i]);
        }
        return numbers;
    }

    private static String[] spiltInput(String input) {
        return input.split(BLACK_STRING);
    }

    private void addOperator(String symbol) {
        BiFunction operator = OperatorEnum.getOperator(symbol);
        operators.add(operator);
    }

    private void addNumber(String number) {
        try {
            numbers.add(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }

    public int calculate() {
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = (int) operators.get(i).apply(result, numbers.get(i + 1));
        }
        return result;
    }
}
