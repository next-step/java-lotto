import java.util.List;

public class Numbers {
    private final List<Number> numbers = null;

    public Numbers(List<String> numbers) {
        for (String number : numbers) {
            this.numbers.add(new Number(number));
        }
    }
}
