package step2.validator;

public class StringNumberValidator {
    public static final String BLANK = "";
    public static final String WHITE_SPACE = " ";
    public static final String COMMA = ",";
    private static final String SPLIT_REGEX = COMMA + WHITE_SPACE;

    public static String[] splitNumbers(String numbers) {
        validateStringNumbers(numbers);
        return numbers.split(SPLIT_REGEX);
    }

    public static void validateStringNumbers(String numbers) {
        if (BLANK.equals(numbers) || COMMA.equals(numbers)) {
            throw new IllegalArgumentException("공백 혹은 빈 값은 허용하지 않습니다.");
        }
    }
}
