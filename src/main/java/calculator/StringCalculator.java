package calculator;

import calculator.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/]");

    private StringCalculator() {
        throw new UnsupportedOperationException("유틸 클래스는 생성할 수 없습니다.");
    }

    public static int calculate(final String input) {
        validateInput(input);
        List<Integer> numbers = getNumberElements(input);
        List<String> operators = getOperatorElements(input);
        int calculatedValue = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int value = numbers.get(i);
            String operator = operators.get(i - 1);
            calculatedValue = getResult(calculatedValue, operator, value);
        }
        return calculatedValue;
    }

    private static int getResult(final int calculatedValue, String operator, final int value) {
        switch (operator) {
            case "+":
                return calculatedValue + value;
            case "-":
                return calculatedValue - value;
            case "*":
                return calculatedValue * value;
            case "/":
                return calculatedValue / value;
            default:
                return calculatedValue;
        }
    }

    private static boolean containsOperators(final String input) {
        return OPERATOR_PATTERN.matcher(input).matches();
    }

    private static boolean containsNumbers(final String input) {
        return NUMBER_PATTERN.matcher(input).matches();
    }


    private static String[] getElements(final String input) {
        return input.split(" ");
    }

    private static List<Integer> getNumberElements(final String input) {
        return Arrays.stream(getElements(input))
                .filter(StringCalculator::containsNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<String> getOperatorElements(final String input) {
        return Arrays.stream(getElements(input))
                .filter(StringCalculator::containsOperators)
                .collect(Collectors.toList());
    }

    private static void validateInput(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("입력값에 null 또는 공백만 존재하여 계산을 할 수 없습니다.");
        }
    }
}
