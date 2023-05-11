package calculator.parser;

import calculator.parser.converter.StringConverter;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionParser {
    private final StringConverter<Integer> stringToIntegerConverter;
    private final ExpressionValidator validator;
    private final String delimiter;

    public ExpressionParser(StringConverter<Integer> stringToIntegerConverter,
                            ExpressionValidator expressionValidator,
                            String delimiter) {
        this.stringToIntegerConverter = stringToIntegerConverter;
        this.validator = expressionValidator;
        this.delimiter = delimiter;
    }

    public Expression parse(String expression) {
        validator.validate(expression);

        Deque<String> operators = new LinkedList<>();
        Deque<Integer> operands = new LinkedList<>();

        String[] parts = expression.split(delimiter);

        for (int evenIdx = 0; evenIdx < parts.length; evenIdx += 2) {
            operands.addLast(stringToIntegerConverter.convert(parts[evenIdx]));
        }

        for (int oddIdx = 1; oddIdx < parts.length; oddIdx += 2) {
            operators.addLast(parts[oddIdx]);
        }

        return new Expression(operands, operators);
    }
}
