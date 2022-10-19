package string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import string.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    @Test
    void 텍스트_숫자로_변환() {
        int result = Calculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 덧셈_계산하기() {
        int result = Calculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 뺄셈_계산하기() {
        int result = Calculator.calculate("10 - 2 - 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 곱셈_계산하기() {
        int result = Calculator.calculate("10 * 2 * 3");
        assertThat(result).isEqualTo(60);
    }

    @Test
    void 나눗셈_계산하기() {
        int result = Calculator.calculate("10 / 2 / 3");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 여러_연산자_계산하기() {
        int result = Calculator.calculate("10 + 2 * 3 / 6 - 1");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 연산자외_다른_기호_들어오면_exception_처리() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate("10 ! 10");
        }).withMessageContaining("사칙연산이 아닙니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 공백이_들어오면_exception_처리(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate(input);
        }).withMessageContaining("유효하지 않은 입력값입니다.");
    }
}
