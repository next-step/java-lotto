package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinningPriceTest {

    @Test
    void tests() {
        final WinningPrice winningPrices = WinningPrice.getWinningPrice(2);

        assertThat(winningPrices).isEqualTo(WinningPrice.NONE);
    }
}
