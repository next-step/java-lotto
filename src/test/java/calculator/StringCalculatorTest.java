package calculator;

import calculator.domain.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


public class StringCalculatorTest {
    @Test
    void 문자열_초기화() {
        StringCalculator calculator = new StringCalculator("1 + 2");
        Assertions.assertThat(calculator.value()).containsExactly("1", "+", "2");
    }

    @Test
    void 계산() {
        StringCalculator calculator = new StringCalculator("2 + 3 * 4 / 2");
        Assertions.assertThat(calculator.calculate()).isEqualTo(10);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void Null_이거나_빈값일_수_없음(String expression) {
        assertThatThrownBy(()->{
            new StringCalculator(expression);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null 이거나 빈 문자열일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  "})
    void 공백일_수_없음(String expression) {

        assertThatThrownBy(()->{
            new StringCalculator(expression);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백 문자열일 수 없습니다.");
    }

    @Test
    void 숫자가_아닐_경우_예외() {
        assertThatThrownBy(()->{
            new StringCalculator("1 + 2a + 3").calculate();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로 이루어져 있지 않음");
    }
}
