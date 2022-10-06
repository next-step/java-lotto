package calculator.domain;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by seungwoo.song on 2022-10-05
 */
public class Calculator {

    private Deque<Operator> operatorBox = new ArrayDeque<>(1);
    private int result = 0;

    public void push(Operator operator) {
        operatorBox.push(operator);
    }

    public void calculate(int input) {
        if (operatorBox.isEmpty()) {
            result = input;
            return;
        }

        result = operatorBox.pop().operate(result, input);
    }

    public int getResult() {
        return result;
    }
}
