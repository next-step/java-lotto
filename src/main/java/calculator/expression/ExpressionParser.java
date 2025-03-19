package calculator.expression;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {

    public static List<ExpressionComponent> parse(String input) {
        if(isEmpty(input)) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
        return convert(split(input));
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static List<String> split(String input){
        return List.of(input.split(" "));
    }

    private static List<ExpressionComponent> convert(List<String> tokens){
        List<ExpressionComponent> expressionComponents = new ArrayList<>();
        for (String token : tokens) {
            expressionComponents.add(ExpressionComponentFactory.valueOf(token));
        }
        return expressionComponents;
    }
}
