package calculator;

import java.util.Objects;

public class StringCalculator {
    public static int cal(String input) {

        if (isBlank(input)) {
            throw new IllegalArgumentException("빈 문자가 입력되었습니다.");
        }

        String[] stringList = split(input);
        int stringLength = stringList.length;
        int result = parseInteger(stringList[0]);

        if (stringLength == 1) {
            return result;
        }

        for (int i=2; i<stringLength; i = i+2) {
            result = calculator(result, parseInteger(stringList[i]), stringList[i-1]);
        }

        return result;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static String[] split(String input) {
        return input.split(" ");
    }

    private static int calculator(int result, int number, String operation) {
        if (Objects.equals(operation, "+")) {
            return Math.addExact(result, number);
        }

        if (Objects.equals(operation, "-")) {
            return Math.subtractExact(result, number);
        }

        if (Objects.equals(operation, "*")) {
            return Math.multiplyExact(result, number);
        }

        if (Objects.equals(operation, "/")) {
            return Math.floorDiv(result, number);
        }

        throw new IllegalArgumentException("올바른 연산자가 입력되지 않았습니다.");
    }

    private static int parseInteger(String number) {
        return Integer.parseInt(number);
    }

}
