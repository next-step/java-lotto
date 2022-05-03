package util;

public class OperationUtil {

    public static String[] splitString(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("연산식을 입력해주세요.");
        }
        return value.split(" ");
    }
}
