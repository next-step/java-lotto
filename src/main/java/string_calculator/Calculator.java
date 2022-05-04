package string_calculator;

import java.util.List;
import java.util.ListIterator;

public class Calculator {
    private Integer accumulator;

    public Integer computes(List<Object> values) {
        ListIterator<Object> iterator = values.listIterator();
        computeNext(iterator);
        return accumulator;
    }

    private void computeNext(ListIterator<Object> iterator) {
        if (!iterator.hasNext()) {
            return;
        }
        Object value = iterator.next();
        if (value instanceof Operator) {
            compute(this.accumulator, (Operator) value, (Integer) iterator.next());
            computeNext(iterator);
            return;
        }
        if (value instanceof Integer) {
            this.accumulator = (Integer) value;
            computeNext(iterator);
            return;
        }
        throw new IllegalArgumentException("Wrong values found.");
    }

    private void compute(Integer acc, Operator operator, Integer operand) {
        this.accumulator = operator.compute.apply(acc, operand);
    }
}
