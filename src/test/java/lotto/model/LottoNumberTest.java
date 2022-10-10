package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumberTest {

    @DisplayName("로또 번호가 생성된다.")
    @Test
    void createLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(1);
        Assertions.assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @DisplayName("로또 번호 1~45사이가 아닐 경우 에러를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void validateLottoNumber(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoNumber(input);
                });
    }
}
