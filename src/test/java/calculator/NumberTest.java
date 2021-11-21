package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @Test
    void sum() {
        Number number = new Number(30);

        Number result = number.sum(new Number(60));

        assertThat(result)
                .isEqualTo(new Number(90));
    }

    @Test
    @DisplayName("숫자 이외의 값 RuntimeException")
    void createNotNumberThrowRuntimeException() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Number("$"));
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Number("?"));
    }

    @Test
    @DisplayName("음수 RuntimeException")
    void createNegativeThrowRuntimeException() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Number("-1"));
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Number(-1));
    }
}