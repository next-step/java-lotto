import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private static final Number ZERO = new Number(0);

    private final List<Number> numbers;

    public Numbers(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public Numbers(final String expression){
        this. numbers = splitFromDelimiter(expression);
    }

    private List<Number> splitFromDelimiter(String expression){
        return Arrays.stream(expression.split(","))
            .map(Number::new).collect(Collectors.toList());
    }

    public Number sum() {
        return numbers.stream()
            .reduce(ZERO, Number::add);
    }

    public void register(Number number) {
        numbers.add(number);
    }

    public Number get(int idx){
        return numbers.get(idx);
    }
}
