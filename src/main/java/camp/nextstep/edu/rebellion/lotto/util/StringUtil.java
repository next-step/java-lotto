package camp.nextstep.edu.rebellion.lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {
    private static final String DEFAULT_SPLIT_DELIMITER = ",";
    private static final String EMPTY = "";

    private StringUtil(){}

    public static boolean isEmpty(String str) {
        return null == str || EMPTY.equals(str);
    }

    public static List<String> convertList(String str, String delimiter) {
        if (isEmpty(str)) {
            return new ArrayList<>();
        }
        return Arrays.asList(str.trim().split(delimiter));
    }

    public static List<String> convertList(String str) {
        return convertList(str, DEFAULT_SPLIT_DELIMITER);
    }
}
