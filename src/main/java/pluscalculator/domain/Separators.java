package pluscalculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    public Pattern getRegexPattern() {
        return Pattern.compile("[(" + String.join("|", separators) + ")]");
    }

    public Numbers getSplitResult(String expression) {
        String[] splitNumbers = getRegexPattern().split(expression);
        return new Numbers(Arrays.stream(splitNumbers).collect(Collectors.toList()));
    }
}
