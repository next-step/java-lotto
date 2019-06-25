package calculator;

public class ExpressionParser {



    public static NumberElementCollection parse(String expression) {

        if(expression == null){
            return new NumberElementCollection(new String[0]);
        }

        ExpressionSplitter expressionSplitter = new ExpressionSplitter(expression);
        String[] elements = expressionSplitter.split();

        return new NumberElementCollection(elements);
    }
}
