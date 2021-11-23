package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Operands {
    private final List<Operand> numbers;

    public Operands(List<Operand> numbers) {
        this.numbers = numbers;
    }

    public static Operands from(String expression, String delimeter) {
        List<Operand> numbers = Arrays.stream(expression.split(delimeter))
                .map(Operand::from)
                .collect(Collectors.toList());
        return new Operands(numbers);
    }

    public Operand sum() {
        return numbers.stream().reduce(Operand.zero(), Operand::plus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operands operands = (Operands) o;
        return numbers.equals(operands.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
