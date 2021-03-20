package splitandsum;

public class ValidationNumber {

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
        if (number < Constant.INPUT_ZERO) {
            throw new RuntimeException("음수는 입력이 불가능 합니다.");
        }
        return number;
    }

}
