package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 올바른_로또숫자인_경우(int validLottoNumber) {
        LottoNumber lottoNumber = new LottoNumber(validLottoNumber);
        assertThat(lottoNumber.value()).isEqualTo(validLottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 잘못된_로또숫자인_경우_IllegalArgumentException_발생(int invalidLottoNumber) {
        assertThatThrownBy(() -> {
            new LottoNumber(invalidLottoNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
