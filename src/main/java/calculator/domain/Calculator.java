package calculator.domain;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by seungwoo.song on 2022-09-27
 */
public class Calculator {

    private final OperatorBox operatorBox;
    private CalculateResult result;

    public Calculator() {
        this(new OperatorBox());
    }

    public Calculator(OperatorBox operatorBox) {
        this.operatorBox = operatorBox;
    }

    public void calculate(InputValue inputValue) {
        if (inputValue.isOperator()) {
            operatorBox.add(inputValue);
            return;
        }

        if (operatorBox.isEmpty()) {
            result = new CalculateResult(inputValue.toNumber());
            return;
        }

        result = operatorBox.operate(result, inputValue);
    }

    public int getResult() {
        return result.getResult();
    }
}
