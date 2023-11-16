package calculator.domain;

import java.util.Iterator;
import java.util.List;

public class Calculator {

    public static VariableExpression calculate(List<String> origin) {
        Iterator<String> iterator = origin.iterator();
        VariableExpression result = VariableExpression.of(iterator.next());
        while (iterator.hasNext()){
            result = Expression.of(iterator.next()).expression(result, VariableExpression.of(iterator.next())).calculate();
        }
        return result;
    }
}
