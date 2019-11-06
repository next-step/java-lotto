package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static step2.LottoUtil.LOTTO_PRICE;

class WinningCountTest {
    private static WinningCount winningCount = new WinningCount(new int[]{0, 0, 0, 0, 0, 1, 0});

    @Test
    void getWinningRate() {
        assertThat(winningCount.getWinningRate())
                .isEqualTo((float) Prize.getPrice(5) / LOTTO_PRICE);
    }

    @Test
    void getCount() {
        assertAll(
                () -> assertThat(winningCount.getCount(0)).isEqualTo(0),
                () -> assertThat(winningCount.getCount(1)).isEqualTo(0),
                () -> assertThat(winningCount.getCount(2)).isEqualTo(0),
                () -> assertThat(winningCount.getCount(3)).isEqualTo(0),
                () -> assertThat(winningCount.getCount(4)).isEqualTo(0),
                () -> assertThat(winningCount.getCount(5)).isEqualTo(1),
                () -> assertThat(winningCount.getCount(6)).isEqualTo(0)
        );
    }
}