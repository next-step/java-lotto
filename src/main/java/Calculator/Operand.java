/*
* 피연산자 문자열을 입력받아 정수형 원시값으로 포장하고 관련 로직을 수행하는 클래스
* */
package Calculator;

import java.util.Objects;

public class Operand {
    private static int BOUND_NUMBER = 0;
    private static String NEGATVIE_NUMBER_MESSAGE = "음수는 계산할 수 없습니다.";

    private int operand;

    public Operand(String str) {
        operand = Integer.parseInt(str);
    }

    /*
     * 피연산자가 음수인지 확인한다.
     * */
    public boolean checkOperand() {
        if (operand < BOUND_NUMBER) {
            throw new IllegalArgumentException(NEGATVIE_NUMBER_MESSAGE);
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand1 = (Operand) o;
        return operand == operand1.operand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }

}
