package lotto.strategy;

import lotto.domain.LottoNumber;
import lotto.exception.LottoNumberException;
import lotto.exception.LottoNumbersException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ManualNumberStrategyTest {

    @ParameterizedTest
    @ValueSource(strings = {"2,3,d,6,23,45", "2,3,-1,5,6,-4"})
    void notPositive(String lottoNumbers) {
        assertThatExceptionOfType(LottoNumberException.class)
                .isThrownBy(() -> new ManualNumberStrategy(lottoNumbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "41,42,43,44,45,46"})
    void 숫자_범위(String lottoNumbers) {
        assertThatExceptionOfType(LottoNumberException.class)
                .isThrownBy(() -> new ManualNumberStrategy(lottoNumbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 숫자_6개(String lottoNumbers) {
        assertThatExceptionOfType(LottoNumbersException.class)
                .isThrownBy(() -> new ManualNumberStrategy(lottoNumbers));
    }

    @Test
    void 숫자_중복() {
        assertThatExceptionOfType(LottoNumbersException.class)
                .isThrownBy(() -> new ManualNumberStrategy("1,2,3,4,4,6"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "12", "27", "31", "45"})
    void 로또번호_리스트_반환(String number) {
        assertThat(new ManualNumberStrategy("1,2,12,27,31,45").getLottoNumbers())
                .contains(new LottoNumber(number));
    }
}
