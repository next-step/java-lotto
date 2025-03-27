public class ExpressionParser {

    public static final String EXPRESSION_REGEX = "^\\d+( [+\\-*/] \\d+)*$";

    public static String[] parse(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }

        if (!expression.matches(EXPRESSION_REGEX)) {
            throw new IllegalArgumentException();
        }
        return expression.split(" ");
    }
}
