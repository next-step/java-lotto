package stringcalculator.view;

import java.util.Scanner;

public class InputView {

    private static final int PREFIX_LENGTH = 2;

    private static final String PREFIX_REGEX = "//(.+)";
    private static final String DEFAULT_NUMBER = "0";

    public static String inputDelimiter() {
        System.out.println("구분자를 입력해 주세요. (//${구분자}, 입력하지 않으면 기본 구분자(',' ':')가 사용됩니다.");
        String input = input();

        if (!isBlank(input)) {
            validatePrefix(input);
            input = removePrefix(input);
        }

        return input;
    }

    public static String inputExpression() {
        System.out.println("식을 입력해 주세요.");
        String input = input();

        if (isBlank(input)) {
            return DEFAULT_NUMBER;
        }
        return input;
    }

    private static String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static boolean isBlank(String input) {
        return input.trim().isEmpty();
    }

    private static void validatePrefix(String input) {
        if (!input.matches(PREFIX_REGEX)) {
            throw new IllegalArgumentException("올바른 입력형식이 아닙니다. ex) //${delimiter}");
        }
    }

    private static String removePrefix(String input) {
        return input.substring(PREFIX_LENGTH);
    }
}
