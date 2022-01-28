import java.util.List;

public class Numbers {

    private static final Number ZERO = new Number(0);

    private final List<Number> numbers;

    public Numbers(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public Number sum() {
        return numbers.stream()
            .reduce(ZERO, Number::add);
    }

    public void register(Number number) {
        numbers.add(number);
    }
}
