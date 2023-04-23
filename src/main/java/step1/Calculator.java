package step1;

import java.util.*;

public class Calculator {

    private static final String BLACK_STRING = " ";

    private final List<Integer> numbers = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public Calculator(String input) {
        String[] inputArr = spiltInput(input);

        for (int i = 0; i < inputArr.length; i++) {
            splitNumberOperator(inputArr, i);
        }
    }

    private static String[] spiltInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null 이거나 빈 값입니다");
        }
        String[] inputArr = input.split(BLACK_STRING);
        if (!isValidExpression(inputArr)) {
            throw new IllegalArgumentException("식이 올바르지 않습니다");
        }
        return inputArr;
    }

    private static boolean isValidExpression(String[] inputArr) {
        return inputArr.length % 2 != 0;
    }

    private void splitNumberOperator(String[] inputArr, int i) {
        if (i % 2 == 0) {
            addNumber(inputArr[i]);
            return;
        }
        addOperator(inputArr[i]);
    }

    private void addOperator(String symbol) {
        if (!OperatorEnum.isValidSymbol(symbol)) throw new IllegalArgumentException("사칙연산 기호가 아닙니다");
        Operator operator = OperatorEnum.getOperator(symbol);
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
            result = operators.get(i).apply(result, numbers.get(i + 1));
        }
        return result;
    }
}
