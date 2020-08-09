import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final Pattern p = Pattern.compile("//(.)\\\\n(.*)");

    public int calculate(String input, String delimiter) {
        if (input == null || input.isEmpty()) return 0;

        delimiter = String.format("\\%s", delimiter);
        String[] split = input.split(delimiter);

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .reduce(Integer::sum).orElseThrow(RuntimeException::new);
    }

    public List<String> getDelimiterAndInput(String str) {
        Matcher m = p.matcher(str);
        if (m.find()) {
            return Arrays.asList(m.group(1), m.group(2));
        }
        return Collections.emptyList();
    }

    public int calculateDefaultDelimiter(String input) {
        if (input == null || input.isEmpty()) return 0;

        String[] split = input.split("[,:]");

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .reduce(Integer::sum).orElseThrow(RuntimeException::new);
    }
}
