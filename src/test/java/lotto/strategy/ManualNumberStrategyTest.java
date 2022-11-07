package lotto.strategy;

import lotto.exception.LottoNumberException;
import lotto.exception.NotPositiveException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ManualNumberStrategyTest {
    
    @Test
    void null_또는_blank() {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new ManualNumberStrategy(null));

        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new ManualNumberStrategy(""));
    }
    @Test
    void notPositive() {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new ManualNumberStrategy("2,3,d,6,23,45"));

        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new ManualNumberStrategy("2,3,-1,5,6,-4"));
    }

    @Test
    void 숫자_6개() {
        assertThatExceptionOfType(LottoNumberException.class)
                .isThrownBy(() -> new ManualNumberStrategy("1,2,3,4,5"));

        assertThatExceptionOfType(LottoNumberException.class)
                .isThrownBy(() -> new ManualNumberStrategy("1,2,3,4,5,6,7"));
    }

    @Test
    void 숫자_범위() {
        assertThatExceptionOfType(LottoNumberException.class)
                .isThrownBy(() -> new ManualNumberStrategy("0,1,2,3,4,5"));

        assertThatExceptionOfType(LottoNumberException.class)
                .isThrownBy(() -> new ManualNumberStrategy("41,42,43,44,45,46"));
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
