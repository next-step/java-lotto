package step1;

import java.util.LinkedList;
import java.util.Queue;

public class Operators {
    private Queue<String> operators = new LinkedList<>();

    public void add(String input) {
        operators.add(input);
    }

    public int impl(Integer x, Integer y) {
        String operator = operators.poll();

        for (OperatorCaculate value : OperatorCaculate.values()) {
            if (operator.equals(value.getOperator())) {
                return OperatorCaculate.valueOf(value.name()).caclulate(x, y);
            }
        }
        return 0;
    }
}
