package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Calculrator.calculate;
import static org.assertj.core.api.Assertions.*;

public class CalculateTest {

    @Test
    void 입력값_null_illegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculate(null));
    }

    @Test
    void 입력값_공백_illegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculate(""));
    }

    @Test
    void 덧셈_기본동작() {
        assertThat(calculate("1 + 1")).isEqualTo(2);
    }

    @Test
    void 뺄셈_기본동작() {
        assertThat(calculate("2 - 1")).isEqualTo(1);
    }

    @Test
    void 곱셈_기본동작() {
        assertThat(calculate("2 * 1")).isEqualTo(2);
    }

    @Test
    void 나눗셈_기본동작() {
        assertThat(calculate("4 / 2")).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 1 - 1 * 4 / 2, 2",
            "4 - 8 - 4 * 2 / 2, -8",
    })
    void 다중연산(String expression, int expected) {
        assertThat(calculate(expression)).isEqualTo(expected);
    }

    @Test
    void 사칙연산자_외_문자() {
        assertThatThrownBy(() -> calculate("1 ^ 1"))
                .isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("유요하지 않은 연산자: ^");

    }
}
