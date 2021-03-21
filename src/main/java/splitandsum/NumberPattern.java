package splitandsum;

import java.util.Optional;

public class NumberPattern {
    public static final String DEFAULT_PATTERN = ",|:";
    private final String pattern;

    public NumberPattern(String pattern) {
        this.pattern = Optional.ofNullable(pattern).filter(s -> s != "").orElse(DEFAULT_PATTERN);
    }

    public String getPattern() {
        return pattern;
    }
}
