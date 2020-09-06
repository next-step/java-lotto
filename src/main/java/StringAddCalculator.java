import utils.Num;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static utils.Num.add;
import static utils.StringUtils.isNullOrBlank;

public class StringAddCalculator {

    private StringAddCalculator () {}

    public static final int SUM_OF_NULL_OR_EMPTY = 0;

    public static int splitAndSum(String value) {
        if (isNullOrBlank(value)) {
            return SUM_OF_NULL_OR_EMPTY;
        }
        return sum(Splitter.splitToTokens(value));
    }

    private static int sum(String[] tokens) {
        List<Num> numList = stream(tokens)
                        .map(Num::new)
                        .collect(Collectors.toList());
        return add(numList);
    }
}
