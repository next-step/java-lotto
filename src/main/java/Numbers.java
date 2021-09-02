import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private List<Number> numbers = new ArrayList<>();

    public Numbers(List<String> numbers) {
        for (String number : numbers) {
            this.numbers.add(new Number(number));
        }
    }

    public Number add() {
        Number sum = new Number(0);
        for (Number number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Numbers)) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
