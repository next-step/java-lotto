import java.util.Arrays;

public class Accumulator {
    public static int accumulate(int[] numbers) {
        return Arrays.stream(numbers)
            .reduce((number1, number2) -> number1 += number2)
            .getAsInt();
    }
}
