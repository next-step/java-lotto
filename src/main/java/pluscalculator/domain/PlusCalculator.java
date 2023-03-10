package pluscalculator.domain;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PlusCalculator {
    private static final Pattern separatorPattern = Pattern.compile("[(,|:)]");

    public static int plusCalculate(final String plusExpression) {
        Numbers numbers = extractNumbers(plusExpression);
        return numbers.plusAll();
    }

    private static Numbers extractNumbers(final String plusExpression) {
        String[] splitNumbers = separatorPattern.split(plusExpression);
        return new Numbers(Arrays.stream(splitNumbers).map(Integer::parseInt).collect(Collectors.toList()));
    }

}
