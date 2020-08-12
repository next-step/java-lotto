package com.hskim.lotto.ui;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorInputView {

    private static final String INPUT_MESSAGE = "수식을 입력해주세요 : ";
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|;";
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Matcher> matcherCache = new HashMap<>();

    public void printInputMessage() {

        System.out.print(INPUT_MESSAGE);
    }

    public String getUserInput() {

        return scanner.nextLine();
    }

    public List<String> makeTokenList(String input) {

        if (isEmptyOrNull(input)) {

            return Collections.singletonList("0");
        }

        Matcher matcher = findMatcher(input);

        if (matcher.find()) {

            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);

            return Arrays.asList(tokens);
        }

        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }

    private boolean isEmptyOrNull(String input) {

        return input == null || input.isEmpty();
    }

    private Matcher findMatcher(String input) {

        if (matcherCache.containsKey(input)) {

            return matcherCache.get(input);
        }

        Matcher matcher = EXPRESSION_PATTERN.matcher(input);
        matcherCache.put(input, matcher);

        return matcher;
    }
}
