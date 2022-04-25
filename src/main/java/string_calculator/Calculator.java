package string_calculator;

import java.util.List;
import java.util.ListIterator;

public class Calculator {
    private Integer accumulator;

    public Integer computes(List<Value> values) {
        ListIterator<Value> it = values.listIterator();
        while (it.hasNext()) {
            Value v = it.next();
            if (v instanceof Operator) {
                compute(this.accumulator, (Operator) v, (Integer) it.next());
                continue;
            }
            if (v instanceof Integer) {
                this.accumulator = (Integer) v;
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
