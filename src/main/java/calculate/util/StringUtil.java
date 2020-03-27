package calculate.util;

import java.util.Arrays;
import java.util.List;

public final class StringUtil {

    private StringUtil() {
        throw new IllegalArgumentException("생성자 사용 불가");
    }

    public static List<String> splitStringUseDelimiter(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }
}
