import java.util.Arrays;

public class StringCalculator {
    public int calculate(String input) {
        String[] split = input.split(",");

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .reduce(Integer::sum).orElseThrow(RuntimeException::new);
    }
}
