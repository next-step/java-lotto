import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Expression {
    public static final Splitters splitters = new Splitters();
    private final Numbers numbers;

    public Expression(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Expression from(String input) {
        List<Integer> numbers = Arrays.stream(input.split(splitters.getRegex()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Expression(new Numbers(numbers));
    }

    public int sum() {
        return numbers.sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression expression1 = (Expression) o;
        return Objects.equals(numbers, expression1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
