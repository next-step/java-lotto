package calculator;

import static calculator.StringCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 공백이 들어오면 예외를 던진다")
    void fail_for_null_or_empty(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculate(input));
    }

    @Test
    @DisplayName("덧셈 하나를 계산한다")
    void add() {
        assertThat(calculate("3 + 2"))
            .isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 하나를 계산한다")
    void subtract() {
        assertThat(calculate("3 - 2"))
            .isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈 하나를 계산한다")
    void multiply() {
        assertThat(calculate("3 * 2"))
            .isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 하나를 계산한다")
    void divide() {
        assertThat(calculate("3 / 2"))
            .isEqualTo(1);
    }

    @Test
    @DisplayName("잘못된 연산자가 들어오면 예외를 던진다")
    void fail_for_illegal_operator() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculate("3 ! 2"));
    }
}
