import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Calculator {

    public static VariableExpression calculate(List<Character> origin) {
        Iterator<Character> iterator = origin.iterator();
        VariableExpression result = new VariableExpression(iterator.next());
        while (iterator.hasNext()){
            CalculatorService calculatorService = new CalculatorService();
            CalculatorExpression expression = calculatorService.typeOfExpression(iterator.next());
            result = expression.calculate(result, new VariableExpression(iterator.next()));
        }
        return result;
    }
}
