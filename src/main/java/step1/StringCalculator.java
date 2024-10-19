package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static step1.FourBasicOperatorEnum.*;

public class StringCalculator {

    private static final String SPACE_DELIMITER = " ";

    private StringCalculator() {}

    public static int calculate(String text) {
        throwIfNullOrEmpty(text);

        List<Integer> operands = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        separateOperatorAndOperand(splitText(text), operands, operators);

        operators.forEach(StringCalculator::throwIfInvalidOperator);

        return calculation(operands, operators);
    }

    private static void throwIfNullOrEmpty(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("입력값으로 null이나 빈 문자열은 허용하지 않습니다.");
        }
    }

    private static String[] splitText(String text) {
        return text.split(SPACE_DELIMITER);
    }

    private static void separateOperatorAndOperand(String[] strings, List<Integer> operands, List<String> operators) {
        Arrays.stream(strings).forEach(string -> {
            try {
                operands.add(Integer.parseInt(string.trim()));
            } catch (NumberFormatException e) {
                operators.add(string.trim());
            }
        });
    }

    private static void throwIfInvalidOperator(String operator) {
        if (!FourBasicOperatorEnum.isValid(operator)) {
            throw new IllegalArgumentException("올바른 사칙연산 기호(+, -, *, /)를 입력하세요.");
        }
    }

    private static int calculation(List<Integer> operands, List<String> operators) {
        int result = operands.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = fourBasicOperations(operands, operators, i, result);
        }
        return result;
    }

    private static int fourBasicOperations(List<Integer> operands, List<String> operators, int i, int result) {
        if (operators.get(i).equals(ADDITION.getValue())) {
            result += operands.get(i + 1);
        }
        if (operators.get(i).equals(SUBTRACTION.getValue())) {
            result -= operands.get(i + 1);
        }
        if (operators.get(i).equals(MULTIPLICATION.getValue())) {
            result *= operands.get(i + 1);
        }
        if (operators.get(i).equals(DIVISION.getValue())) {
            throwIfDivideByZero(operands.get(i + 1));
            result /= operands.get(i + 1);
        }
        return result;
    }

    private static void throwIfDivideByZero(int operand) {
        if (operand == 0) {
            throw new IllegalArgumentException("나눗셈의 피연산자로 0이 올 수 없습니다.");
        }
    }
}
