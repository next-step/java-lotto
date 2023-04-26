import java.util.Arrays;
import java.util.List;

public class ExpressionParser {
    private final String delimiter;

    public ExpressionParser(String delimiter) {
        this.delimiter = delimiter;
    }

    public List<String> parse(String expression) {
        String[] parts = expression.split(delimiter);

        return Arrays.asList(parts);
    }
}
