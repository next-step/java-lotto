
public class StringCalculator {
    private static final String BLANK = " ";
    public static final String GIVEN_STRING_MUST_NOT_BE_NULL = "입력값은 null 일 수 없습니다.";
    public static final String GIVEN_STRING_MUST_NOT_BE_BLANK = "입력값은 공백 일 수 없습니다.";

    public static int calculate(String givenValue) {
        checkIsNullOrBlank(givenValue);
        String[] strings = givenValue.split(BLANK);
        Calculator calculator = new Calculator();

        for (int operatorIndex = 1; operatorIndex < strings.length; operatorIndex += 2) {
            int result = calculator
                    .calculate(strings[operatorIndex - 1], strings[operatorIndex], strings[operatorIndex + 1]);
            strings[operatorIndex + 1] = String.valueOf(result);
        }

        return Integer.parseInt(strings[strings.length - 1]);
    }

    private static void checkIsNullOrBlank(String givenValue) {
        if (givenValue == null) {
            throw new IllegalArgumentException(GIVEN_STRING_MUST_NOT_BE_NULL);
        }
        if (givenValue.isBlank()) {
            throw new IllegalArgumentException(GIVEN_STRING_MUST_NOT_BE_BLANK);
        }
    }

}
