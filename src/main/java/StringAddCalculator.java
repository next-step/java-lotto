import static java.util.Arrays.stream;
import static utils.StringUtils.isNullOrBlank;

public class StringAddCalculator {

    public static final int SUM_OF_NULL_OR_EMPTY = 0;

    public static int splitAndSum(String value) {
        if (isNullOrBlank(value)) {
            return SUM_OF_NULL_OR_EMPTY;
        }
        return sum(Splitter.splitToTokens(value));
    }

    private static int sum(String[] tokens) {
        return stream(tokens)
                .mapToInt(token -> Integer.parseInt(token))
                .sum();
    }
}
