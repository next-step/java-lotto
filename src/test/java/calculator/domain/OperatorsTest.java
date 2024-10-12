package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorsTest {
    @DisplayName("OperatorType들을 갖는 Operators 객체를 생성한다.")
    @Test
    void create() {
        Operators operators = new Operators(List.of(OperatorType.PLUS, OperatorType.MINUS));

        assertThat(operators.size()).isEqualTo(2);
    }

    @DisplayName("연산자 위치와 피연산자들을 전달하면 연산자 타입에 따라 계산한 값을 반환한다.")
    @Test
    void execute() {
        Operators operators = new Operators(List.of(OperatorType.PLUS, OperatorType.MINUS));

        assertThat(operators.execute(0, new OperandNumber("0"), new OperandNumber("1")))
                .isEqualTo(new OperandNumber("1"));
    }
}