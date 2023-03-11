package pluscalculator.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PlusCalculator {
   static Separators DEFAULT_SEPARATORS = new Separators(Set.of(",", ":"));
    public static int plusCalculate(final String plusExpression) {
        Numbers numbers = extractNumbers(plusExpression);
        return numbers.plusAll();
    }

    private static Pattern getSeparatorPattern(String plusExpression) {
        if (plusExpression.contains("//")&&plusExpression.contains("\n")) {
            String customSeparator = plusExpression.replaceAll("[(\n)].*", "").replaceAll("[//$]", "");
            return DEFAULT_SEPARATORS.add(customSeparator).toRegexPattern();
        }
        return DEFAULT_SEPARATORS.toRegexPattern();
    }

    private static Numbers extractNumbers( final String plusExpression) {
        if (plusExpression == null || plusExpression.isBlank()) {
            return new Numbers();
        }

        Pattern separatorPattern = getSeparatorPattern(plusExpression);
        String[] splitNumbers = separatorPattern.split(cleaningExpression(plusExpression));
        return new Numbers(Arrays.stream(splitNumbers).map(Integer::parseInt).collect(Collectors.toList()));
    }

    private static String cleaningExpression(String plusExpression) {
        return plusExpression.replaceAll("^[//].*[$\n]", "");
    }

}
