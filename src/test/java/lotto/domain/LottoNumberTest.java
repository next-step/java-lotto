package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 25, 45})
    @DisplayName("1-45 사이의 로또 번호 객체 생성")
    void valid_generation(int input) {
        assertThat(LottoNumber.of(input).toString()).isEqualTo(String.valueOf(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 55})
    @DisplayName("1-45이 아닌 로또 번호 객체 생성-예외 발생")
    void invalid_generation(int input) {
        assertThatThrownBy(() -> LottoNumber.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoNumber.NUMBER_EXCEPTION_MESSAGE);
    }
}
