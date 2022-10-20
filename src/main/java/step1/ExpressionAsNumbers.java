package step1;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExpressionAsNumbers {

    private static final Pattern NUMBERS_EXTRACTION_RULE = Pattern.compile("-?\\d+");

    private final String expression;

    public ExpressionAsNumbers(String expression) {
        this.expression = expression;
    }

    public List<Integer> numbers() {
        return NUMBERS_EXTRACTION_RULE.matcher(expression)
                .results()
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }
}
