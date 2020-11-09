package step1;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static step1.Constant.CUSTOM_SEPARATE_REGEX;
import static step1.Constant.DEFAULT_SEPARATE_REGEX;

public enum Separator {
    NONE(input -> new String[]{input}),
    DEFAULT(input -> input.split(Constant.DEFAULT_SEPARATE_REGEX)),
    CUSTOM(input -> {
        Matcher matcher = Pattern.compile(Constant.CUSTOM_SEPARATE_REGEX)
                .matcher(input);
        if (matcher.find()) {
            String separator = matcher.group(Constant.SEPARATOR_GROUP_INDEX);
            return matcher.group(Constant.STRING_GROUP_INDEX)
                    .split(separator);
        }
        return new String[]{input};
    });

    private final Function<String, String[]> function;
    private final static Pattern defaultPattern = Pattern.compile(DEFAULT_SEPARATE_REGEX);
    private final static Pattern customPattern = Pattern.compile(CUSTOM_SEPARATE_REGEX);

    Separator(Function<String, String[]> function) {
        this.function = function;
    }

    public String[] execute(String input) {
        return this.function.apply(input);
    }

    public static Separator getSeparateType(String input) {
        if (isMatchPattern(DEFAULT_SEPARATE_REGEX, input)) {
            return Separator.DEFAULT;
        }
        if (isMatchPattern(CUSTOM_SEPARATE_REGEX, input)) {
            return Separator.CUSTOM;
        }
        return Separator.NONE;
    }

    private static boolean isMatchPattern(String pattern, String input) {
        return Pattern.compile(pattern).matcher(input).find();
    }
}
