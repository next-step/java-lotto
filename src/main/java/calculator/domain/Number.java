package calculator.domain;

import calculator.exception.CalculatorException;
import calculator.type.ExceptionType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Number {
    private int number;

    public Number(String value) {
        if (Objects.isNull(value) || value.trim().isEmpty())
            this.number = 0;

        if (!value.trim().isEmpty())
            this.number = Integer.parseInt(value);

        if (this.number < 0) {
            throw new CalculatorException(ExceptionType.INVALID_NUMBER);
        }
    }

    public int sum(int value) {
        return value + this.number;
    }

    public static List<Number> listOf(List<String> numberValues) {
        return numberValues.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
