package step1;

import java.util.List;

public class Expression {
    public static final Expression EMPTY_EXPRESSION = new Expression("0");
    private final String text;

    private Expression(final String text) {
        this.text = text;
    }

    public static Expression of(final String text) {
        if (StringUtils.isBlank(text)) {
            return EMPTY_EXPRESSION;
        }

        return new Expression(text);
    }

    public String getText() {
        return text;
    }

    public boolean isEmpty() {
        return this == EMPTY_EXPRESSION;
    }

    public boolean hasSingleNumber() {
        return text.length() == 1;
    }

    public boolean isNotNeedCalculate() {
        if (isEmpty()) {
            return true;
        }
        return hasSingleNumber();
    }

    public int toNumber() {
        return Integer.parseInt(text);
    }

    public List<String> separate(final String delimiter) {
        return ExpressionSeparator.split(this, delimiter);
    }
}
