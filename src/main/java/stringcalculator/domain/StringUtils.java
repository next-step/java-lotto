package stringcalculator.domain;

public class StringUtils {

    private static final String INVALID_NUMBER_ERROR_MESSAGE = "피연산자는 숫자를 입력해야 합니다.";
    private static final String EMPTY_OR_NULL_ERROR_MESSAGE = "문자열을 입력해야 합니다.";

    static int toInt(String[] split, int index) {
        try {
            return Integer.parseInt(split[index]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE);
        }
    }

    static String[] getStringArray(String input) {
        validateInput(input);
        String[] stringArray = input.split(" ");
        validateArray(stringArray);
        return stringArray;
    }

    private static void validateArray(String[] stringArray) {
        if (isLessThanThreeValues(stringArray)) {
            throw new IllegalArgumentException("입력값은 3개 이상이어야 합니다.");
        }
        if (stringArray.length % 2 == 0) {
            throw new IllegalArgumentException("입력값은 홀수개이어야 합니다.");
        }
    }

    private static boolean isLessThanThreeValues(String[] stringArray) {
        return stringArray.length < 3;
    }

    private static void validateInput(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(EMPTY_OR_NULL_ERROR_MESSAGE);
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }


}