package pluscalculator.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Separators {
    private final Set<String> separators;

    public Separators(Set<String> separators) {
        this.separators = separators;
    }

    public Separators add(String customSeparator) {
        Set<String> defaultSeparators = new HashSet<>(separators);
        defaultSeparators.add(customSeparator);
        return new Separators(Collections.unmodifiableSet(defaultSeparators));
    }

    public Pattern toRegexPattern() {
        return Pattern.compile("[(" + String.join("|", separators) + ")]");
    }

}
