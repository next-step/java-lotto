import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {

    private static final String REGX_DELIMITER = ",|:";
    private static final String REGX_CUSTOM_DELIMITER = "//(.)\n(.*)";

    private final List<Number> numbers;

    public Numbers(final String expression){
        this. numbers = splitFromDelimiter(expression);
    }

    private List<Number> splitFromDelimiter(String expression){
        Matcher m = Pattern.compile(REGX_CUSTOM_DELIMITER).matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return splitDelimiter(m.group(2).split(customDelimiter));
        }

        return Arrays.stream(expression.split(REGX_DELIMITER))
            .map(Number::new).collect(Collectors.toList());
    }

    private List<Number> splitDelimiter(String[] expression) {
        String join = String.join(",", expression);
        String[] split = join.split(REGX_DELIMITER);
        return Arrays.stream(split)
            .map(Number::new).collect(Collectors.toList());
    }

    public Number get(int idx){
        return numbers.get(idx);
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
