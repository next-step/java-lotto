package util;

public class NumberUtil {

    private final static String MINUS_VALUE_ERROR="음수는 입력될 수 없습니다.";
    public static int stringToInt(String number) {
        int parseInt = Integer.parseInt(number);
        if (parseInt < 0) {
            throw new RuntimeException(MINUS_VALUE_ERROR);
        }
        return parseInt;
    }
}
