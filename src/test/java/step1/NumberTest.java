package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "==", "<>"})
    @DisplayName("숫자문자가 아닌 경우")
    void not_number(String value) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new Number(value));
    }

    @Test
    @DisplayName("음수인 경우")
    void negative_number() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new Number("-1"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    @DisplayName("양수인 경우")
    void valid_number(String value) {
        assertThat(new Number(value).getNumber()).isEqualTo(Integer.parseInt(value));
    }
}
