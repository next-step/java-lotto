package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {

    private static final String LOTTO_SPLIT_DELIMITER = ",";

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

    public static List<Integer> splitStringToIntegers(String input) {
        List<Integer> result = new ArrayList<>();
        String[] split = input.split(LOTTO_SPLIT_DELIMITER);

        for (String s : split) {
            result.add(Integer.parseInt(s.trim()));
        }
        return result;
    }
}
