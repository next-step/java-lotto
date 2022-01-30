package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.in;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @DisplayName("구분자의 시작과 끝은 숫자이면 안된다.")
    @ValueSource(strings = {"3a3", "123", "22a", "aa3"})
    @ParameterizedTest
    void delimiter_구분자의_시작과_끝은_숫자(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Delimiter(input));
    }
}
