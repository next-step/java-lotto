package lotto.domain.ticket;

import lotto.common.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @Test
    @DisplayName("로또번호가 최소값으로 생성이되는지 확인한다")
    void createLottoNumberMin() {
        LottoNumber lottoNumber = LottoNumber.of(PositiveNumber.of(1L));
        assertThat(lottoNumber.get()).isEqualTo(1L);
    }

    @Test
    @DisplayName("로또번호가 최대값으로 생성이되는지 확인한다")
    void createLottoNumberMax() {
        LottoNumber lottoNumber = LottoNumber.of(PositiveNumber.of(45L));
        assertThat(lottoNumber.get()).isEqualTo(45L);
    }

    @Test
    @DisplayName("로또번호가 최소값보다 작은경우 예외처리를 확인한다")
    void checkException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoNumber.of(PositiveNumber.of(0L));
                }).withMessageMatching("Invalid lotto number");
    }

    @Test
    @DisplayName("로또번호가 최대값보다 큰경우 예외처리를 확인한다")
    void checkException2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoNumber.of(PositiveNumber.of(46L));
                }).withMessageMatching("Invalid lotto number");
    }
}
