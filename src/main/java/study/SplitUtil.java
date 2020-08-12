package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitUtil {

    public static final String SPLIT_DELIMITER = "[,:]";

    private SplitUtil() {
    }

    public static List<Integer> splitExpression(String expression) {
        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(expression);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.stream(matcher.group(2).split(customDelimiter)).map(Integer::parseInt).collect(Collectors.toList());
        }

        return Arrays.stream(expression.split(SPLIT_DELIMITER)).map(Integer::parseInt).collect(Collectors.toList());
    }

}
