/*
* 피연산자 숫자들을 입력받아 연산을 수행하고 결과값을 반환하는 클래스
* */
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
