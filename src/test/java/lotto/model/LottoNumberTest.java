package lotto.model;

import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    public void 로또_숫자_범위_검증(String number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(InvalidLottoNumberException.class);
    }
}