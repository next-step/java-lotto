package lotto.domain;

import lotto.exception.InvalidBoundLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("LottoNumber 를 0으로 생성 시 InvalidBoundLottoNumber 를 반환한다.")
    void invalidMinBound() {
        assertThatThrownBy(() -> LottoNumber.valueOf(0)).isInstanceOf(InvalidBoundLottoNumber.class);
    }

    @Test
    @DisplayName("LottoNumber 를 46으로 생성 시 InvalidBoundLottoNumber 를 반환한다.")
    void invalidMaxBound() {
        assertThatThrownBy(() -> LottoNumber.valueOf(46)).isInstanceOf(InvalidBoundLottoNumber.class);
    }

    @Test
    @DisplayName("문자열 1을 이용해 생성하면 LottoNumber(1)을 반환한다.")
    void stringToLottoNumber() {
        assertThat(LottoNumber.valueOf("1")).isEqualTo(LottoNumber.valueOf(1));
    }
}