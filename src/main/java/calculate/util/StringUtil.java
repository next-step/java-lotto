package calculate.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class StringUtil {
    private StringUtil() {
        throw new IllegalArgumentException("생성자 사용 불가");
    }


    public static List<String> splitStringUseDelimiter(String input, String delimiter) {
        if (Objects.isNull(input)) {
            return Arrays.asList("0");
        }
        return Arrays.asList(input.split(delimiter));
    }
}
