package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호는 번호가 1 ~ 45의 범위를 가질 때 정상적으로 생성된다.")
    void create() {

        int minNumber = 1;
        int maxNumber = 45;

        Assertions.assertThatNoException()
                .isThrownBy(() -> new LottoNumber(minNumber));
        Assertions.assertThatNoException()
                .isThrownBy(() -> new LottoNumber(maxNumber));
    }

    @Test
    @DisplayName("로또 번호는 정상 범위 이외일 때 예외를 던진다.")
    void validLottoNumber() {

        int underMinNumber = 0;
        int overMaxNumber = 46;

        Assertions.assertThatThrownBy(() -> new LottoNumber(underMinNumber))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new LottoNumber(overMaxNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
