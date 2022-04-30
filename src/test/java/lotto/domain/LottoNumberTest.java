package lotto.domain;

import lotto.exception.InvalidBoundLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("LottoNumber 를 0으로 생성 시 InvalidBoundLottoNumber 를 반환한다.")
    void invalidMinBound() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(InvalidBoundLottoNumber.class);
    }

    @Test
    @DisplayName("LottoNumber 를 46으로 생성 시 InvalidBoundLottoNumber 를 반환한다.")
    void invalidMaxBound() {
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(InvalidBoundLottoNumber.class);
    }
}