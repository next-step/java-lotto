package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningPriceTest {

    @Test
    void enum_FIVE_반환_테스트() {
        WinningPrice winningPrice = WinningPrice.of(5, 0);
        Assertions.assertThat(winningPrice).isEqualTo(WinningPrice.Five);
    }

    @Test
    void enum_FIVE_BONUS_반환_테스트() {
        WinningPrice winningPrice = WinningPrice.of(5, 1);
        Assertions.assertThat(winningPrice).isEqualTo(WinningPrice.FiveWithBonus);
    }

    @Test
    void 로또_당첨_금액_테스트() {
        WinningPrice winningPrice = WinningPrice.of(5, 0);
        Assertions.assertThat(winningPrice.operate(1)).isEqualTo(1500000);
    }


}
