package kr.heesu.calculator.utils;

import kr.heesu.calculator.domain.Arguments;
import kr.heesu.calculator.domain.Expression;
import kr.heesu.calculator.domain.Number;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExpressionFactory {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.*)";

    private ExpressionFactory() {}

    public static Expression getExpressionFromInput(String input) {
        if (isEmpty(input)) {
            return Expression.of(Arguments.of(new ArrayList<>()));
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX)
                .matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String customInput = matcher.group(2);

            return Expression.of(makeArgument(customInput.split(customDelimiter)));
        }
        return Expression.of(makeArgument(input.split(DEFAULT_DELIMITERS)));
    }

    private static Arguments makeArgument(String[] candidates) {
        return Arguments.of(Stream.of(candidates)
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toList()));
    }

    private static boolean isEmpty(String input) {
        return (input == null || input.isEmpty());
    }
}
