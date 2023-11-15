import java.util.HashMap;
import java.util.Map;

public class CalculatorService {

    private static Map<Character, CalculatorExpression> expressionMap;

    public CalculatorService() {
        expressionMap = new HashMap<>();
        expressionMap.put('+', new AddExpression());
        expressionMap.put('-', new MinusExpression());
        expressionMap.put('*', new MultiplicationExpression());
        expressionMap.put('/', new DivideExpression());
    }

    public CalculatorExpression typeOfExpression(char mark){
        return expressionMap.get(mark);
    }
}
