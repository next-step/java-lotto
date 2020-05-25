package step1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Splitter {

    private final static String SEPARATE_PATTERN = "[,:]";

    public static List<Operand> split(Formula formula) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(formula.get());

        String[] tokens;
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(Pattern.quote(customDelimiter));
        } else {
            tokens = formula.get().split(SEPARATE_PATTERN);
        }

        return Arrays.stream(tokens)
                .map(Operand::valueOf)
                .collect(Collectors.toList());
    }
}
