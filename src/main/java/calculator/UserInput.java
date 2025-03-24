package calculator;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private static final String DEFAULT_DELIMITER = " ";

    private final List<Integer> numbers = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public static UserInput fromStringInput(String input) {
        UserInput userInput = new UserInput();

        validateBlankInput(input);
        String[] splitInput = split(input);
        setExpression(userInput, splitInput);

        return userInput;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    private static String[] split(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private static void setExpression(UserInput userInput, String[] input) {
        validateExpressionLength(input);
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) setNumbers(userInput.numbers, input[i]);
            if (i % 2 == 1) setOperators(userInput.operators, input[i]);
        }
    }

    private static void setNumbers(List<Integer> numbers, String number) {
        validateNumber(number);
        numbers.add(Integer.parseInt(number));
    }

    private static void setOperators(List<Operator> operators, String operator) {
        operators.add(Operator.fromSymbol(operator));
    }

    private static void validateBlankInput(String input) {
        if (input == null || input.isBlank()) throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
    }

    private static void validateExpressionLength(String[] expression) {
        if (expression.length % 2 == 0) throw new IllegalArgumentException("숫자와 연산자를 포함한 수식의 길이는 홀수여야 합니다.");
    }

    private static void validateNumber(String number) {
        if (number == null || number.isEmpty()) throw new IllegalArgumentException("숫자가 비었습니다.");
        if (!number.chars().allMatch(Character::isDigit)) throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
    }
}
