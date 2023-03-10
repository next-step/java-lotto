package pluscalculator.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PlusCalculator {

    public static Numbers extractNumbers(final String plusExpression) {
        String[] splitNumbers = plusExpression.split(",");
        return new Numbers(Arrays.stream(splitNumbers).map(Integer::parseInt).collect(Collectors.toList()));
    }
}
