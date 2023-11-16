package calculator.domain;

import java.util.Iterator;
import java.util.List;

public class Calculator {

    public static Variable calculate(List<String> origin) {
        Iterator<String> iterator = origin.iterator();
        Variable result = Variable.of(iterator.next());
        while (iterator.hasNext()){
            String anyExpression = iterator.next();
            String anyVariable = iterator.next();
            result = Expression.of(anyExpression).expression(result, Variable.of(anyVariable)).calculate();
        }
        return result;
    }
}
