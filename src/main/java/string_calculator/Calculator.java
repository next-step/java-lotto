package string_calculator;

import java.util.List;

public class Calculator {
    private Integer accumulator;

    public Integer computes(List<Value> values) {
        int i = 0;
        while (i < values.size()) {
            Value value = values.get(i);
            if (value instanceof Operator) {
                compute(this.accumulator, (Operator) value, (Integer) values.get(i + 1));
                i += 2;
                continue;
            }
            if (value instanceof Integer) {
                this.accumulator = (Integer) value;
                i++;
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
