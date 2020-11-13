import java.util.Arrays;

public class StringAddCalculator {
    public static Number splitAndSum(String sentence) {
        if (!validateSentence(sentence)) {
            return new Number(0);
        }

        return calculate(sentence);
    }

    private static Number calculate(String sentence) {
        CustomSentenceDivider customSentenceDivider = new CustomSentenceDivider(sentence);
        if (customSentenceDivider.isCustomExpression()) {
            Expression expression = getExpFromCustomSplitterDivider(customSentenceDivider);
            return expression.sum();
        }

        Expression expression = new Expression(sentence, new Splitters());
        return expression.sum();
    }

    private static Expression getExpFromCustomSplitterDivider(CustomSentenceDivider customSentenceDivider) {
        Splitters splitters = new Splitters(Arrays.asList(customSentenceDivider.getSplitter()));
        return new Expression(customSentenceDivider.getExpressionString(), splitters);
    }

    private static boolean validateSentence(String sentence) {
        if (checkNull(sentence)) {
            return false;
        }

        return !checkEmptyString(sentence);
    }

    private static boolean checkEmptyString(String sentence) {
        return sentence.isEmpty();
    }

    private static boolean checkNull(String sentence) {
        return sentence == null;
    }
}
