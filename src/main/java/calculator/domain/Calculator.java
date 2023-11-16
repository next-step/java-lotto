package calculator.domain;

import calculator.domain.CalculatorExpression;
import calculator.domain.CalculatorService;
import calculator.domain.VariableExpression;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

public class Calculator {

    public static VariableExpression calculate(List<String> origin) {
        Iterator<String> iterator = origin.iterator();
        VariableExpression result = new VariableExpression(iterator.next());
        while (iterator.hasNext()){
            CalculatorService calculatorService = new CalculatorService();
            BiFunction<VariableExpression, VariableExpression, CalculatorExpression> biFunction = calculatorService.typeOfExpression(
                iterator.next());
            result = biFunction.apply(result,new VariableExpression(iterator.next())).calculate();
        }
        return result;
    }
}
