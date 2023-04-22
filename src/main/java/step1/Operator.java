package step1;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Operator {

    private final BiFunction<Integer,Integer, Integer> operator;

    public Operator(String current) {
        if(current.equals("+")) {
            this.operator = (i1, i2) -> i1 + i2;
            return;
        }
        if(current.equals("-")) {
            this.operator = (i1, i2) -> i1 - i2;
            return;
        }
        if(current.equals("*")) {
            this.operator = (i1, i2) -> i1 * i2;
            return;
        }
        if(current.equals("/")) {
            this.operator = (i1, i2) -> i1 / i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    int calculate(int leftValue, int rightValue) {
        return operator.apply(leftValue, rightValue);
    }

}
