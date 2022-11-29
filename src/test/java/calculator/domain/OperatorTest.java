package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 특정_기호만_허용(String operator) {
        assertThatNoException().isThrownBy(() -> new Operator(operator));
    }

    @ParameterizedTest
    @ValueSource(strings = {"<", "?", "!"})
    void 허용되지_않은_기호는_에러(String operator) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Operator(operator));
    }
}