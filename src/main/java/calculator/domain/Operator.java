/*
* 연산자를 반환하는 클래스
* */
package calculator.domain;

import java.util.function.BinaryOperator;

public class Operator {

    public static BinaryOperator<Integer> add(){
        return (a, b) -> a + b;
    }
}
