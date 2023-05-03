package calculator.parser;

import java.util.Arrays;
import java.util.List;

public class ExpressionParser {
    private final ExpressionValidator validator;
    private final String delimiter;

    public ExpressionParser(ExpressionValidator expressionValidator,
                            String delimiter) {
        this.validator = expressionValidator;
        this.delimiter = delimiter;
    }

    public List<String> parse(String expression) {
        validator.validate(expression);

        String[] parts = expression.split(delimiter);

        return Arrays.asList(parts);
    }
}
