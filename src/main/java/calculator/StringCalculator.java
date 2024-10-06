package calculator;

import calculator.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String REGEX = "[+\\-*/]";
    private static final Pattern COMPILE = Pattern.compile(REGEX);

    private StringCalculator() {
        throw new UnsupportedOperationException("유틸 클래스는 생성할 수 없습니다.");
    }

    public static int calculate(final String input) {
        validateInput(input);
        List<Integer> numbers = getNumberElements(input);
        List<String> operators = getOperatorElements(input);
        int calculatedValue = numbers.get(0);
        for (int i=1; i<numbers.size(); i++) {
            int value= numbers.get(i);
            String operator = operators.get(i-1);
            calculatedValue = getResult(calculatedValue, operator, value);
        }
        return calculatedValue;
    }

    private static int getResult(int calculatedValue, String operator, int value) {
        if ("+".equals(operator)) {
            calculatedValue = calculatedValue + value;
        }
        return calculatedValue;
    }

    public static boolean containsOperators(String input) {
        return COMPILE.matcher(input).find();
    }


    private static String[] getElements(String input) {
        return input.split(" ");
    }

    private static List<Integer> getNumberElements(String input) {
        return Arrays.stream(getElements(input))
                .filter(element -> !containsOperators(element))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<String> getOperatorElements(String input) {
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
