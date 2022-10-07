package stringcalculator.util;

public class ConvertUtil {

    public static int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환할 수 없는 문자열입니다.");
        }
    }
}
