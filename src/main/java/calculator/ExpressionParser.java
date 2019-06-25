package calculator;

public class ExpressionParser {



    public static NumberElementCollection parse(String expression) {

        if(expression == null){
            return new NumberElementCollection(new String[0]);
        }

        SeparateStringExtractor separateStringExtractor = new SeparateStringExtractor(expression);

        return new NumberElementCollection(separateStringExtractor.getExpression().split(separateStringExtractor.getSeparator()));
    }
}
