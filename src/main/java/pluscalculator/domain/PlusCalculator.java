package pluscalculator.domain;

import java.util.Set;

public class PlusCalculator {
   static Separators DEFAULT_SEPARATORS = new Separators(Set.of(",", ":"));
    public static double plusCalculate(final String plusExpression) {
        Numbers numbers = extractNumbers(plusExpression);
        return numbers.plusAll();
    }

    private static Numbers extractNumbers( final String plusExpression) {
        if (plusExpression == null || plusExpression.isBlank()) {
            return new Numbers();
        }
        Separators separators = getSeparators(plusExpression);
        return separators.getSplitResult(cleaningCustomSeparatorsExpression(plusExpression));
    }

    private static Separators getSeparators(final String plusExpression) {
        if (plusExpression.contains("//") && plusExpression.contains("\n")) {
            String customSeparator = plusExpression.replaceAll("[(\n)].*", "").replaceAll("[//$]", "");
            return DEFAULT_SEPARATORS.add(customSeparator);
        }
        return DEFAULT_SEPARATORS;
    }

    private static String cleaningCustomSeparatorsExpression(final String plusExpression) {
        return plusExpression.replaceAll("^[//].*[$\n]", "");
    }

}
