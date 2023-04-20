package view;

import domain.Operator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Set<String> OPERATORS = Arrays.stream(Operator.values())
            .map(Operator::getOperator)
            .collect(Collectors.toSet());
    private static final String STRING_EMPTY = " ";

    private InputView() {
    }

    public static String inputExpression() {
        System.out.println("2 + 3 * 4 / 2와 같은 형식으로 문자열 입력하세요.");

        String inputExpression = SCANNER.nextLine();
        validateInputExpressionAndThrow(inputExpression);

        return inputExpression;
    }

    public static void validateInputExpressionAndThrow(String inputExpression) {
        if (inputExpression == null || inputExpression.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백인 문자입니다.");
        }
        if (!isArithmeticExpression(inputExpression)) {
            throw new IllegalArgumentException(String.format("식에 포함된 기호는 사칙연산 %s 기호만 가능합니다.", OPERATORS));
        }
    }

    public static List<Integer> extractNumbers(String splitExpression) {
        return splitInputExpression(splitExpression).stream()
                .filter(str -> str.matches("[0-9]+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> extractOperators(String splitExpression) {
        return splitInputExpression(splitExpression).stream()
                .filter(str -> !str.matches("[0-9]+"))
                .collect(Collectors.toList());
    }

    private static List<String> splitInputExpression(String inputExpression) {
        return Arrays.asList(inputExpression.split(STRING_EMPTY));
    }

    private static boolean isArithmeticExpression(String inputExpression) {
        for (char c : inputExpression.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isWhitespace(c) && !isArithmeticOperator(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isArithmeticOperator(char c) {
        return OPERATORS.contains(Character.toString(c));
    }
}
