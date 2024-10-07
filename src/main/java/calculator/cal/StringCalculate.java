package calculator.cal;

import calculator.operator.Operator;

import static calculator.operator.Operator.*;

public class StringCalculate {

    public static int calculate(int x, String operator, int y) {
        return operator(operator).apply(x, y);
    }


}
