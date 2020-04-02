import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static List<Number> toArray(String expression) {
        if (isNullOrEmpty(expression)) {
            return new ArrayList<>();
        }
        String[] numbers = expression.split(DEFAULT_DELIMITER);
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || "".equals(expression);
    }

}
