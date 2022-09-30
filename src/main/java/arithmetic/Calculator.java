package arithmetic;

import java.util.List;

import arithmetic.operator.Expression;
import arithmetic.operator.Number;
import arithmetic.operator.Operation;

public class Calculator {
    public Number calculate(Expression expression) {
        return calculate(expression.numbers(), expression.operations());
    }

    private Number calculate(List<Number> numbers, List<Operation> operations) {
        Number result = operations.get(0).compute(numbers.get(0), numbers.get(1));
        for (int index = 1; index < operations.size(); index++) {
            result = operations.get(index).compute(result, numbers.get(index + 1));
        }
        return result;
    }
}
