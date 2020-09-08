package stringcalculator.expression;

import stringcalculator.common.ExpressionException;
import stringcalculator.common.ExpressionExtractor;
import stringcalculator.common.ExpressionValidator;

import java.util.Objects;

public class Expression {
    private ExpressionNumbers expressionNumbers;
    private Delimiter delimiter;

    private Expression(String expressionValue) {
        validate(expressionValue);
        splitDelimiterAndNumbers(expressionValue);

    }

    private void splitDelimiterAndNumbers(String expressionValue) {
        this.delimiter = ExpressionExtractor.extractDelimiter(expressionValue);

        String expression = ExpressionExtractor.extractNumbers(expressionValue);
        this.expressionNumbers = delimiter.splitValue(expression);
    }

    private void validate(String expressionValue) {
        if (!ExpressionValidator.validExpression(expressionValue)) {
            ExpressionException.wrongExpression();
        }
    }

    public static Expression newInstance(String expressionValue) {
        return new Expression(expressionValue);
    }

    public ExpressionNumber sum() {
        return expressionNumbers.sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(expressionNumbers, that.expressionNumbers) &&
                Objects.equals(delimiter, that.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expressionNumbers, delimiter);
    }
}
