package lotto.util.validator;

public class GeneralValidator {
    private GeneralValidator() {
    }

    public static void validateDuplicateSubstring(String substring, String value, String target) {
        if (containsDuplicateSubstring(substring, value)) {
            throw new IllegalArgumentException(String.format("%s에 구분자는 하나만 입력해주세요", target));
        }
    }

    public static void validateStartSubstring(String substring, String value, String target) {
        if (value.startsWith(substring)) {
            throw new IllegalArgumentException(String.format("%s은(는) 구분자로 시작할 수 없습니다.", target));
        }
    }

    public static void validateEndSubstring(String substring, String value, String target) {
        if (value.endsWith(substring)) {
            throw new IllegalArgumentException(String.format("%s은(는) 구분자로 끝날 수 없습니다.", target));
        }
    }

    public static void validatePositiveNumber(int number, String target) {
        if (!isPositiveNumber(number)) {
            throw new IllegalArgumentException(String.format("%s은(는) 0보다 큰 수여야 합니다..", target));
        }
    }
    private static boolean containsDuplicateSubstring(String substring, String value) {
        String doubleSubstring = substring.repeat(2);
        return value.contains(doubleSubstring);
    }

    private static boolean isPositiveNumber(int number) {
        return number > 0;
    }
}
