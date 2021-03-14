package study.calculator;

public class DefaultPattern implements PatternSeparator {

    public static final String DEFAULT_PATTERN = ",|:";

    @Override
    public String[] matches(String text) {
        return text.split(DEFAULT_PATTERN);
    }
}
