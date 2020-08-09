import java.util.Arrays;

public class StringCalculator {
    public int calculate(String input, String delimiter) {
        String[] split = input.split(delimiter);

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .reduce(Integer::sum).orElseThrow(RuntimeException::new);
    }
}
