package util;

import lotto.exception.NoInstantiationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class StringUtil {

    private static final String LOTTO_SPLIT_DELIMITER = ",";
    private static final String NUMERIC_VALID_MESSAGE = "숫자 형태를 입력해 주세요.";

    private StringUtil() {
        throw new NoInstantiationException(this.getClass().getSimpleName());
    }

    public static List<String> splitStringUseDelimiter(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    public static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NUMERIC_VALID_MESSAGE);
        }
    }

    public static List<Integer> splitStringToIntegers(String input) {
        List<Integer> result = new ArrayList<>();
        String[] split = input.split(LOTTO_SPLIT_DELIMITER);

        for (String s : split) {
            result.add(parseStringToInt(s.trim()));
        }
        return result;
    }
}
