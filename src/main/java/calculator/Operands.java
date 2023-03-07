package calculator;

import java.util.List;

public class Operands {

    List<Operand> operandList; // 연산자 객체 리스트

    /**
     * 연산자 리스트 생성자
     *
     * @param operands : 연산자 리스트 객체
     */
    public Operands(List<Operand> operands) {
        operandList = operands;
    }

    /**
     * 연산자 리스트 합계 리턴 함수
     *
     * @return : 연산자 리스트 합계
     */
    public int operandsSum() {
        return operandList.stream().map(Operand::getOperand).mapToInt(i -> i).sum();
    }
}
