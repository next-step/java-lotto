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

        for (int idx = 0; idx < parts.length; idx++) {
            if (idx % 2 == 0) {
                operands.addLast(stringToIntegerConverter.convert(parts[idx]));
            } else {
                operators.addLast(parts[idx]);
            }
        }

        return new Expression(operands, operators);
    }
}
