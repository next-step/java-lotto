package calculator;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {

    public static Expression parse(String inputString) {
        if (isBlank(inputString)) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자 입니다.");
        }
        String[] elements = splitByEmptySpace(inputString);
        if (isEven(elements.length)) {
            throw new IllegalArgumentException("숫자와 연산자 총 합은 홀수 이어야 합니다.");
        }

        return makeExpression(elements);
    }

    private static boolean isBlank(String inputString) {
        return inputString == null || inputString.isBlank();
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static String[] splitByEmptySpace(String inputString) {
        return inputString.split(" ");
    }

    private static Expression makeExpression(String[] elements) {
        List<Number> numbers = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();
        numbers.add(new Number(elements[0]));
        for (int i = 1; i < elements.length; i += 2) {
            operators.add(Operator.of(elements[i]));
            numbers.add(new Number(elements[i + 1]));
        }
        return new Expression(numbers, operators);
    }

}
