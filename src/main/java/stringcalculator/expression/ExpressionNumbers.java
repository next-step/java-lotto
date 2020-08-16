package stringcalculator.expression;

import stringcalculator.common.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExpressionNumbers {
    private List<ExpressionNumber> expressionNumbers;

    private ExpressionNumbers(String[] values) {
        validate(values);

        this.expressionNumbers = Arrays.stream(values)
                .map(numberValue -> ExpressionNumber.newInstance(numberValue))
                .collect(Collectors.toList());
    }

    private void validate(String[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_NUMBER.printMessage());
        }
    }

    public static ExpressionNumbers newInstance(String[] values) {
        return new ExpressionNumbers(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressionNumbers that = (ExpressionNumbers) o;
        return Objects.equals(expressionNumbers, that.expressionNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expressionNumbers);
    }

    public ExpressionNumber sum() {
        ExpressionNumber expressionNumber = ExpressionNumber.newInstance();
        for (ExpressionNumber expressionValue : expressionNumbers) {
            expressionNumber.add(expressionValue);
        }

        return expressionNumber;
    }
}
