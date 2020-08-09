import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int calculate(String input, String delimiter) {
        String[] split = input.split(delimiter);

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .reduce(Integer::sum).orElseThrow(RuntimeException::new);
    }

    public Optional<String> getDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (m.find()) {
            return Optional.ofNullable(m.group(1));
        }
        return Optional.empty();
    }
}
