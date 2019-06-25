package calculator;

public class ExpressionParser {
    public static NumberElementCollection parse(String expression) {

        if(expression == null){
            return new NumberElementCollection(new String[0]);
        }

        return new NumberElementCollection(expression.split(":"));
    }
}
