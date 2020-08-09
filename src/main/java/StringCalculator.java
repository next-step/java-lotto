import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int calculate(String input, String delimiter) {
        delimiter = String.format("\\%s", delimiter);
        String[] split = input.split(delimiter);

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .reduce(Integer::sum).orElseThrow(RuntimeException::new);
    }

    public List<String> getDelimiterAndInput(String str) {
        Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(str);
        if (m.find()) {
            return Arrays.asList(m.group(1), m.group(2));
        }
        return Collections.emptyList();
    }
}
