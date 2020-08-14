package com.hskim.lotto.calculator.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hs kim on 2020/08/14
 */
public class UserInput {

    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Map<String, Matcher> matcherCache = new HashMap<>();

    private String userInput;
    private Matcher matcher;

    public UserInput(String userInput) {
        this.userInput = Optional.ofNullable(userInput).orElse("");
        setMatcher();
    }

    private void setMatcher() {
        if (matcherCache.containsKey(userInput)) {
            matcher = matcherCache.get(userInput);
            return;
        }

        Matcher newMatcher = EXPRESSION_PATTERN.matcher(userInput);
        matcherCache.put(userInput, newMatcher);

        matcher = newMatcher;
    }

    public CalculatorNumberTokens getNumberTokens() {
        if (StringUtils.isBlank(userInput)) {
            return new CalculatorNumberTokens(Collections.singletonList("0"));
        }

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);

            return new CalculatorNumberTokens(Arrays.asList(tokens));
        }

        return new CalculatorNumberTokens(Arrays.asList(userInput.split(DEFAULT_DELIMITER)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInput)) return false;
        UserInput userInput1 = (UserInput) o;
        return Objects.equals(userInput, userInput1.userInput) &&
                Objects.equals(matcher, userInput1.matcher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userInput, matcher);
    }
}
