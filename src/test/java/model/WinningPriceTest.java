package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinningPriceTest {

    @Test
    void 일치하는_개수에_해당하는_당첨_금액을_반환한다() {
        final WinningPrice winningPrices = WinningPrice.getWinningPrice(2);

        assertThat(winningPrices).isEqualTo(WinningPrice.NONE);
    }
}
