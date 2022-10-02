package calculator.domain;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by seungwoo.song on 2022-09-27
 */
public class Calculator {

    private Deque<Operator> operator = new ArrayDeque<>();
    private int result;

    public void calculate(String value) {
        if (Operator.isOperator(value)) {
            operator.push(Operator.from(value));
            return;
        }

        if (operator.isEmpty()) {
            result = Integer.parseInt(value);
            return;
        }

        result = operator.pop().operate(result, Integer.parseInt(value));
    }

    public int getResult() {
        return result;
    }
}
