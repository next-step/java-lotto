package string_calculator;

import java.util.List;
import java.util.ListIterator;

public class Calculator {
    private Integer accumulator;

    public Integer computes(List<Value> values) {
        ListIterator<Value> iterator = values.listIterator();
        while (iterator.hasNext()) {
            Value value = iterator.next();
            if (value instanceof Operator) {
                compute(this.accumulator, (Operator) value, (Integer) iterator.next());
                continue;
            }
            if (value instanceof Integer) {
                this.accumulator = (Integer) value;
                continue;
            }
            throw new IllegalArgumentException("Wrong values found.");
        }
        return accumulator;
    }

    private void compute(Integer acc, Operator operator, Integer operand) {
        this.accumulator = operator.compute(acc, operator, operand);
    }
}
