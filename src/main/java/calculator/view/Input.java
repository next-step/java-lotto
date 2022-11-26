package calculator.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SINGLE_SPACE = " ";
    private static final Pattern EXPRESSION_FORMAT_PATTERN = Pattern.compile("(\\d+ \\D )*\\d+");

    public static List<String> readExpression() {
        String expression = SCANNER.nextLine();
        validateExpressionFormat(expression);
        return Arrays.asList(expression.split(SINGLE_SPACE));
    }

    private static void validateExpressionFormat(String expression) {
        if (!EXPRESSION_FORMAT_PATTERN.matcher(expression).matches()) {
            throw new IllegalArgumentException("연산자와 숫자는 공백으로 구분해야 하고, 번갈아 나와야 합니다");
        }
    }
}
