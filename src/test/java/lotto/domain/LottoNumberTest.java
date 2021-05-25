package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LottoNumberTest {

    @DisplayName("로또 번호를 생성하고, 생성된 번호를 리턴한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void createWithValidNumber(final int number) {
        final LottoNumber lottoNumber = LottoNumber.of(number);

        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @DisplayName("유효한 로또 번호가 아니라면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createWithInvalidNumber(final int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNumber.of(number));
    }
}
