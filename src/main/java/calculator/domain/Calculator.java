package calculator.domain;

import java.util.Objects;

public class Calculator {

    private static final int INTEGER_DEFAULT_VALUE = 0;

    public int add(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return INTEGER_DEFAULT_VALUE;
        }

        final DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer(text);
        final Parser parser = new Parser(text, delimiterTokenizer.parseDelimiters());
        final Operands operands = new Operands(parser.parseOperands());
        return operands.getResult();
    }
}

