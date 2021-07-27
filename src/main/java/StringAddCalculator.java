import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static final String REGEX = ",|:";
    public static final int DEFAULT_VALUE = 0;

    public List<Integer> splitAndReturnNumberList(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.singletonList(DEFAULT_VALUE);
        }
        return Arrays.stream(input.split(REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
