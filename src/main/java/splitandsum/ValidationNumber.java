package splitandsum;

public class ValidationNumber {
    public static final int INPUT_ZERO = 0;
    public static final String ERROR_NEGATIVE = "음수는 입력이 불가능 합니다.";
    public static String checkNumber(String number) {
        number = isNull(number);
        number = isEmptyNum(number);
        return number;
    }

    private static String isNull(String number) {
        if (number == null) {
            return "0";
        }
        return number;
    }

    private static String isEmptyNum(String number) {
        if (number.isEmpty()) {
            return "0";
        }
        return number;
    }

    public static int isNegativeNum(int number) {
        if (number < INPUT_ZERO) {
            throw new RuntimeException(ERROR_NEGATIVE);
        }
        return number;
    }

}
