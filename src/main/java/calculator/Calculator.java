package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    private static final String INPUT_MESSAGE = "문자를 입력해주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";
    private static final String BLANK = " ";
    private static final String ONE_TO_NINE_REX_PATTERN = "\\d+";
    private static String[] values;

    public static void input() {
        System.out.println(INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        validateValue(input);
        values = removeBlank(input);
    }

    public static void start(String[] values) {

        int result = 0;
        String operator = "+";
        for (int i = 0; i < values.length; i++) {
            result = calculation(values[i], operator, result);
            operator = values[i];
        }
        System.out.println(RESULT_MESSAGE + result);

    }

    static String[] removeBlank(String input) {
        return input.split(BLANK);
    }

    static int calculation(String value, String operator, int result) {
        if (isNumber(value)) {
            return calculationByOperator(Operator.findByOperator(operator), result, Integer.parseInt(value));
        }
        return result;
    }

    static int calculationByOperator(Operator operator, int result, int nextValue) {
        if (Operator.PLUS == operator) return result + nextValue;
        if (Operator.MINUS == operator) return result - nextValue;
        if (Operator.MULTIPLY == operator) return result * nextValue;
        return result / nextValue;
    }

    static boolean isNumber(String text) {
        return Pattern.matches(ONE_TO_NINE_REX_PATTERN, text);
    }

    static void validateValue(String value) {
        if (value == null || value.isEmpty()) throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
    }

}
