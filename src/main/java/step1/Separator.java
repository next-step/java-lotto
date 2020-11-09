package step1;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Separator {
    NONE(input -> new String[]{input}),
    DEFAULT(input -> input.split(Constant.DEFAULT_SPLIT_REGEX)),
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

    Separator(Function<String, String[]> function) {
        this.function = function;
    }

    public String[] execute(String input) {
        return this.function.apply(input);
    }
}
