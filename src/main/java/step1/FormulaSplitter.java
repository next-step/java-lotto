package step1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FormulaSplitter {

    private final static String DEFAULT_DELIMITER_REGEX = "[,:]";
    private final static Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile(DEFAULT_DELIMITER_REGEX);

    private final static String CUSTOM_DELIMITER_SEARCH_REGEX = "//(.)\n(.*)";
    private final static Pattern CUSTOM_DELIMITER_SEARCH_PATTERN = Pattern.compile(CUSTOM_DELIMITER_SEARCH_REGEX);

    public static List<Operand> split(Formula formula) {
        return Arrays.stream(getTokens(formula))
                .map(Operand::valueOf)
                .collect(Collectors.toList());
    }

    private static String[] getTokens(Formula formula) {
        Matcher matcher = CUSTOM_DELIMITER_SEARCH_PATTERN.matcher(formula.get());
        if (matcher.find()) {
            return matcher.group(2).split(Pattern.quote(matcher.group(1)));
        }

        return DEFAULT_DELIMITER_PATTERN.split(formula.get());
    }
}
