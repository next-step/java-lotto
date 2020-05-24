package step1;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String formula) {
        Integer[] tokens = Splitter.split(StringUtils.blankToZero(formula));

        return Arrays.stream(tokens)
                .reduce(0, Integer::sum);
    }
}
