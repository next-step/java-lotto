package util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    private StringUtil() {
        throw new IllegalArgumentException("생성자 사용 불가");
    }

    public static List<String> splitStringUseDelimiter(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    public static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 형태를 입력해 주세요.");
        }
    }
}
