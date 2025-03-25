package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 25, 45})
    void valid_generation(int input) {
        assertThat(LottoNumber.of(input).toString()).isEqualTo(String.valueOf(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 55})
    void invalid_generation(int input) {
        assertThatThrownBy(() -> LottoNumber.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoNumber.NUMBER_EXCEPTION_MESSAGE);
    }
}
