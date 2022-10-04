package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @Test
    @DisplayName("덧셈 연산자 검증")
    void operatePlus() {
        assertThat(Operator.from("+").execute(10, 5)).isEqualTo(15);
    }

    @Test
    @DisplayName("뺄셈 연산자 검증")
    void operateMinus() {
        assertThat(Operator.from("-").execute(10, 5)).isEqualTo(5);
        assertThat(Operator.from("-").execute(5, 10)).isEqualTo(-5);
    }

    @Test
    @DisplayName("곱셈 연산자 검증")
    void operateMultiply() {
        assertThat(Operator.from("*").execute(10, 5)).isEqualTo(50);
    }

    @Test
    @DisplayName("나눗셈 연산자 검증")
    void operateDivide() {
        assertThat(Operator.from("/").execute(10, 2)).isEqualTo(5);
    }

    @Test
    @DisplayName("나눗셈 연산자 결과 소수값 예외 검증")
    void operateDivideDecimalException() {
        assertThatThrownBy(() -> Operator.from("/").execute(10, 5))
        .isInstanceOf(IllegalArgumentException.class);
    }
}
