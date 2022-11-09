package lotto.strategy;

import lotto.exception.LottoNumberException;
import lotto.exception.NotPositiveException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ManualNumberStrategyTest {

    @ParameterizedTest
    @NullAndEmptySource
    void null_또는_blank(String input) {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new ManualNumberStrategy(input));
    }
    @ParameterizedTest
    @ValueSource(strings = {"2,3,d,6,23,45", "2,3,-1,5,6,-4"})
    void notPositive(String lottoNumbers) {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new ManualNumberStrategy(lottoNumbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 숫자_6개(String lottoNumbers) {
        assertThatExceptionOfType(LottoNumberException.class)
                .isThrownBy(() -> new ManualNumberStrategy(lottoNumbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "41,42,43,44,45,46"})
    void 숫자_범위(String lottoNumbers) {
        assertThatExceptionOfType(LottoNumberException.class)
                .isThrownBy(() -> new ManualNumberStrategy(lottoNumbers));
    }

    @Test
    void 숫자_중복() {
        assertThatExceptionOfType(LottoNumberException.class)
                .isThrownBy(() -> new ManualNumberStrategy("1,2,3,4,4,6"));
    }

    @Test
    void 숫자_리스트_반환() {
        assertThat(new ManualNumberStrategy("1,2,12,27,31,45").getNumbers())
                .isEqualTo(Arrays.asList(1,2,12,27,31,45));
    }
}
