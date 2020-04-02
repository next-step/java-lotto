import java.util.Collections;
import java.util.List;

public class Numbers {

    private List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public int sum() {
        return numbers.stream()
                .map(Number::get)
                .reduce(0, Integer::sum);
    }

}
