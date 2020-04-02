import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static Numbers create(List<Integer> numbers) {
        List<Number> collect = numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
        return new Numbers(collect);
    }

    public int sum() {
        return numbers.stream()
                .map(Number::get)
                .reduce(0, Integer::sum);
    }

}
