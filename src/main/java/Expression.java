import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Expression {
    private final Numbers numbers;
    private final Splitters splitters;

    public Expression(String input, Splitters splitters) {
        this.numbers = new Numbers(
                Arrays.stream(input.split(splitters.getRegex()))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
        this.splitters = splitters;

    }

    public int sum() {
        return numbers.sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(numbers, that.numbers) &&
                Objects.equals(splitters, that.splitters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, splitters);
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
