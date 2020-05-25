package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    private final static String SEPARATE_PATTERN = "[,:]";

    public static Integer[] split(Formula formula) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(formula.get());

        String[] tokens;
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(Pattern.quote(customDelimiter));
        } else {
            tokens = formula.get().split(SEPARATE_PATTERN);
        }

        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
