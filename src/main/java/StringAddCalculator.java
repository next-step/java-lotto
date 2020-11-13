import java.util.Collections;
import java.util.Objects;

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
        Splitters splitters = new Splitters(Collections.singletonList(customSentenceDivider.getSplitter()));
        return new Expression(customSentenceDivider.getExpressionString(), splitters);
    }

    private static boolean validateSentence(String sentence) {
        if (Objects.isNull(sentence)) {
            return false;
        }

        return !checkEmptyString(sentence);
    }

    private static boolean checkEmptyString(String sentence) {
        return sentence.isEmpty();
    }
}
