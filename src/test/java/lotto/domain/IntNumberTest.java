package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "45", "9"})
    void 문자열_숫자_입력시(String numberText) {
        assertThat(new IntNumber(numberText)).isEqualTo(new IntNumber(numberText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"s", "bsd", "avv"})
    void 문자열이_숫자가_아닐때(String text) {
        assertThatThrownBy(() -> new IntNumber(text))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
