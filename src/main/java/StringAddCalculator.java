import java.util.Arrays;

public class StringAddCalculator {
    public static Number splitAndSum(String input) {
        if (!validateInput(input))
            return new Number(0);

        return calculate(input);
    }

    private static Number calculate(String input) {
        CustomSplitterDivider customSplitterDivider = new CustomSplitterDivider(input);
        if (customSplitterDivider.isCustomExpression()) {
            return getCustomSplitterDividerSum(customSplitterDivider);
        }

        Expression expression = new Expression(input, new Splitters());
        return expression.sum();
    }

    private static Number getCustomSplitterDividerSum(CustomSplitterDivider customSplitterDivider) {
        Splitters splitters = new Splitters(Arrays.asList(customSplitterDivider.getSplitter()));
        Expression expression = new Expression(customSplitterDivider.getExpressionString(), splitters);
        return expression.sum();
    }

    private static boolean validateInput(String input) {
        if (checkNull(input))
            return false;

        return !checkEmptyString(input);
    }

    private static boolean checkEmptyString(String input) {
        return input.isEmpty();
    }

    private static boolean checkNull(String input) {
        return input == null;
    }
}
