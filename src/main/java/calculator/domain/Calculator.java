package calculator.domain;

import java.util.Iterator;
import java.util.List;

public class Calculator {

    public static Variable calculate(List<String> origin) {
        Iterator<String> iterator = origin.iterator();
        Variable result = Variable.of(iterator.next());
        while (iterator.hasNext()){
            result = Expression.of(iterator.next()).expression(result, Variable.of(iterator.next())).calculate();
        }
        return result;
    }
}
