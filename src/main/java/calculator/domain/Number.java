package calculator.domain;

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
            throw new RuntimeException("Cannot be less than 0");
        }
    }

    public int sum(int value) {
        return value + this.number;
    }

    public static List<Number> listOf(List<String> numberValues) {
        return numberValues.stream()
                .map(numberValue -> new Number(numberValue))
                .collect(Collectors.toList());
    }
}
