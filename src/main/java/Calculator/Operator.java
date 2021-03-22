package Calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class Operator {

    private static BinaryOperator<Integer> binOp = (a, b) -> a + b;

    public static int add(int[] operands){
        return Arrays.stream(operands)
                .map(o -> binOp.apply(0, o))
                .sum();
    }
}
