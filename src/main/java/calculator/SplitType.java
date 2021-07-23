package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum SplitType {

    DEFAULT(new DefaultSplitter(), Pattern.compile(",|:")),
    CUSTOM(new CustomSplitter(), Pattern.compile("//(.)\n(.*)")),
    SINGLE(new SingleSplitter(), Pattern.compile("^[0-9]*$"));

    private final Splitter splitter;
    private final Pattern pattern;

    SplitType(Splitter splitter, Pattern pattern) {
        this.splitter = splitter;
        this.pattern = pattern;
    }

    public static SplitType getSplitType(String str) {
        return Arrays.stream(values())
                .filter(f -> f.pattern.matcher(str).find())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Splitter getSplitter() {
        return splitter;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
