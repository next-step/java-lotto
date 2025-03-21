import java.util.List;
import java.util.stream.IntStream;

public class StringCalculator {
    public double calculate(UserInput input) {
        List<Integer> numbers = input.getNumbers();
        List<Operator> operators = input.getOperators();

        return IntStream.range(0, operators.size())
                .reduce(numbers.get(0),
                        (acc, i) -> operators.get(i).apply(acc, numbers.get(i + 1)));
    }
}
