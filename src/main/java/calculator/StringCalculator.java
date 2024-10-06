package calculator;

import calculator.util.StringUtils;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final String REGEX = "[+\\-*/]";
    private static final Pattern COMPILE = Pattern.compile(REGEX);

    private StringCalculator() {
        throw new UnsupportedOperationException("유틸 클래스는 생성할 수 없습니다.");
    }

    public static int calculate(final String input) {
        validateInput(input);
        String[] elements = getElements(input);
        int calculatedValue = Integer.parseInt(elements[0]);
        String operator = null;
        for (int i = 1; i < elements.length; i++) {
            if (containsOperators(elements[i])) {
                operator = elements[i];
                continue;
            }
            calculatedValue = getResult(calculatedValue, operator, Integer.parseInt(elements[i]));
        }
        return calculatedValue;
    }

    private static int getResult(int calculatedValue, String operator, int number) {
        if ("+".equals(operator)) {
            calculatedValue = calculatedValue + number;
        }
        return calculatedValue;
    }

    public static boolean containsOperators(String input) {
        return COMPILE.matcher(input).find();
    }


    private static String[] getElements(String input) {
        return input.split(" ");
    }

    private static void validateInput(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("입력값에 null 또는 공백만 존재하여 계산을 할 수 없습니다.");
        }
    }
}
