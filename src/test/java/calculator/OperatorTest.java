package calculator;

import static calculator.Operator.ADD;
import static calculator.Operator.DIV;
import static calculator.Operator.MULTIPLY;
import static calculator.Operator.SUB;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    @DisplayName("덧셈 연산")
    void apply_add_test() {
        assertThat(ADD.apply(15, 17))
                .isEqualTo(32);
    }

    @Test
    @DisplayName("뺄셈 연산")
    void apply_sub_test() {
        assertThat(SUB.apply(15, 17))
                .isEqualTo(-2);
    }

    @Test
    @DisplayName("곱셈 연산")
    void apply_multiply_test() {
        assertThat(MULTIPLY.apply(15, 17))
                .isEqualTo(255);
    }

    @Test
    @DisplayName("나눗셈 연산")
    void apply_div_test() {
        assertThat(DIV.apply(15, 3))
                .isEqualTo(5);
    }


    @Test
    @DisplayName("0으로 나누려고 하면 예외 발생.")
    void fail_to_apply_div_by_zero() {
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> DIV.apply(5, 0));
    }
}