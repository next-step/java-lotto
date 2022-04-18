package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("숫자 생성")
class NumberTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Number.from("1"));
    }

    @ParameterizedTest
    @DisplayName("반드시 숫자 형태의 값")
    @ValueSource(strings = {"", "abc"})
    void instance_invalidNumberFormat_thrownIllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.from(value));
    }
}
