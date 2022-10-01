package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import step1.domain.Number;
import step1.domain.Operator;

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
        List<Number> numbers = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();

        for (int i = 0; i < splitStrings.size(); i += 2) {
            numbers.add(new Number(splitStrings.get(i)));
        }

        for (int i = 1; i < splitStrings.size(); i += 2) {
            operators.add(Operator.of(splitStrings.get(i)));
        }

        return new ParserResult(numbers, operators);
    }

    private static boolean isEmptyString(String str) {
        return str == null || str.isEmpty();
    }
}
