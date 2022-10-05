package step1.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class InputParser {
    private static final String EMPTY_STRING_EXCEPTION_MESSAGE = "입력 값이 비어있습니다.";
    private static final String PARSE_REGEX = " ";

    public static ParserResult parseExpression(String expression) {
        if (isEmptyString(expression)) {
            throw new IllegalArgumentException(EMPTY_STRING_EXCEPTION_MESSAGE);
        }

        return doParse(Arrays.asList(expression.split(PARSE_REGEX)));
    }

    private static ParserResult doParse(List<String> splitStrings) {
        List<Number> numbers = getNumbers(splitStrings);
        List<Operator> operators = getOperators(splitStrings);

        return new ParserResult(numbers, operators);
    }

    private static boolean isEmptyString(String str) {
        return str == null || str.isEmpty();
    }

    private static List<Number> getNumbers(List<String> strings) {
        return transformFrom(strings, 0, Number::new);
    }

    private static List<Operator> getOperators(List<String> strings) {
        return transformFrom(strings, 1, Operator::of);
    }

    private static <T, R> List<R> transformFrom(List<T> strings, int startIndex, Function<T, R> transformFunction) {
        List<R> result = new ArrayList<>();

        for (int i = startIndex; i < strings.size(); i += 2) {
            result.add(transformFunction.apply(strings.get(i)));
        }

        return result;
    }
}
