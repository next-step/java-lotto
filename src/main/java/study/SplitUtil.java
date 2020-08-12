package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitUtil {

    public static final String SPLIT_DELIMITER = "[,:]";

    private SplitUtil() {
    }

    public static List<Integer> splitExpression(String expression) {
        return Arrays.stream(expression.split(SPLIT_DELIMITER)).map(Integer::parseInt).collect(Collectors.toList());
    }
}
