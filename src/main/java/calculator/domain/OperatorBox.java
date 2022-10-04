package calculator.domain;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by seungwoo.song on 2022-10-04
 */
public class OperatorBox {

    private Deque<Operator> operators = new ArrayDeque<>();;

    public void add(InputValue inputValue) {
        if (!inputValue.isOperator()) {
            return;
        }

        operators.push(inputValue.toOperator());
    }

    public CalculateResult operate(CalculateResult calculateResult, InputValue inputValue) {
        if (operators.isEmpty()) {
            return calculateResult;
        }

        return operators.pop().operate(calculateResult, inputValue);
    }

    public boolean isEmpty() {
        return operators.isEmpty();
    }
}
