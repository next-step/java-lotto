import java.util.Arrays;

public class CalculatorUtils {

    public static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .map(n -> new PositiveNumber(n).getPositiveNumber())
                .reduce(0, Integer::sum);
    }
}
