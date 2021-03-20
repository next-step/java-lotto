package splitandsum;

import java.util.Optional;

public class NumberPattern {
    private final String pattern;

    public NumberPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return Optional.ofNullable(pattern).filter(s -> s != "").orElse(Constant.DEFAULT_PATTERN);
    }
}
