package calculator;

public class ExpressionParser {

    private static final String SEPARATOR_PATTERN = ":|,";

    public static NumberElementCollection parse(String expression) {

        if(expression == null){
            return new NumberElementCollection(new String[0]);
        }

        return new NumberElementCollection(expression.split(SEPARATOR_PATTERN));
    }
}
