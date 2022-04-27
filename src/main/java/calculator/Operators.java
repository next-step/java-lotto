package calculator;

import java.util.List;

public class Operators {

    private int index;
    private List<String> operations;

    public Operators(List<String> operations) {
        this.index = -1;
        this.operations = operations;
    }

    public boolean next() {
        index++;
        return index < operations.size();
    }

    public Operation findOperator() {
        for (Operation value : Operation.values()) {
            if (value.operator.equals(operations.get(index))) {
                return value;
            }
        }
        return null;
    }
}
