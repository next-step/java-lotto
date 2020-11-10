import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {
    public static final String SPLIT_UNIT = ",";
    List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(String input) {
        List<Integer> numbers = Arrays.stream(input.split(SPLIT_UNIT))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Numbers(numbers);
    }

    public int sum() {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
