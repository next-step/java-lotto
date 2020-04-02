import java.util.Collections;
import java.util.List;

public class Numbers {

    private List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public int sum() {
        int sum = 0;
        for (Number number : numbers) {
            sum += number.get();
        }
        return sum;
    }

}
