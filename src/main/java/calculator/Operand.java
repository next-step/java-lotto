package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Operand {

    private final int operand; // 연산자 변수

    /**
     * 생성자
     *
     * @param operand : 연산자
     */
    public Operand(int operand) {
        this.operand = this.negativeValueCheck(operand);
    }

    /**
     * 연산자 getter
     *
     * @return : operand
     */
    public int getOperand() {
        return this.operand;
    }

    /**
     * 음수 연산자 체크 함수
     *
     * @param operand : 연산자
     * @return operand
     * @throws RuntimeException
     */
    private int negativeValueCheck(int operand) {
        if (operand < 0) {
            throw new RuntimeException("연산 대상 (" + operand + ") 은 음수일 수 없습니다.");
        }
        return operand;
    }

    /**
     * 분리된 연산자 문자열 배열을 Operand 리스트로 반환
     *
     * @param seperatedValue : 연산자 문자열 배열
     * @return : List<Operand> 타입 객체
     */
    public static List<Operand> parseOperand(String[] seperatedValue) {
        return Arrays.stream(seperatedValue)
            .map(Integer::parseInt)
            .mapToInt(Integer::intValue)
            .mapToObj(Operand::new)
            .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operand operand1 = (Operand) o;
        return operand == operand1.operand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }
}
