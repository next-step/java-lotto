package step1;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String formula) {
        String filteredFormula = StringUtils.blankToZero(formula);

        String[] tokens = filteredFormula.split(",");

        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
