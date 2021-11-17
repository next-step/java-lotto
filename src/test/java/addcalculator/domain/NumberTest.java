package addcalculator.domain;

import addcalculator.exception.NotNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("음수 또는문자열이 들어갈 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "문자열", "-3"
    })
    void exceptionTest(String input) {
        assertThatThrownBy(() -> Number.of(input))
                .isInstanceOf(NotNumberException.class);
    }


}