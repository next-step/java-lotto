package calculator.domain;

import java.util.Stack;

/**
 * Created by seungwoo.song on 2022-09-27
 */
public class CalculateResult {

    private Stack<Operator> operatorStack = new Stack<>();
    private int result = 0;

    public void calculate(int value) {
        if (operatorStack.isEmpty()) {
            result = value;
            return;
        }

        result = operatorStack.pop().operate(result, value);;
    }

    public void addOperate(Operator operator) {
        operatorStack.push(operator);
    }

    public int result() {
        return result;
    }
}
