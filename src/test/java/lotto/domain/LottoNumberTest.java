package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 로또번호_생성(int value) {
        LottoNumber lottoNumber = new LottoNumber(value);
        assertThat(lottoNumber).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    void 로또번호_검증(int value) {
        assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}