package step1.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountUtil {
    public static int countByExpression(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()) {
            count += 1;
        }

        return count;
    }
}
