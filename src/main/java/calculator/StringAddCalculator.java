package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;

public class StringAddCalculator {

    private static final String NEGATIVE_ERROR_MESSAGE = "음수는 사용할 수 없습니다";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiters.add(customDelimiter);
            text = matcher.group(2);
        }

        return splitAndSum(text, delimiters);
    }

    private static int splitAndSum(String text, List<String> delimiters) {
        String[] tokens = text.split(String.join("|", delimiters));
        int sum = 0;
        for (String token : tokens) {
            int num = Integer.parseInt(token);
            checkArgument(num >= 0, NEGATIVE_ERROR_MESSAGE);
            sum += num;
        }
        return sum;
    }
}
