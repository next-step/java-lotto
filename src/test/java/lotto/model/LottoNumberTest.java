package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void 생성() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void 로또번호는_1부터_45까지(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(InvalidLottoException.class);
    }
}
