package step2;

import org.junit.jupiter.api.Test;
import step2.Data.Prize;
import step2.Model.Ticket;
import step2.Model.WinningCount;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningCountTest {
    private static WinningCount winningCount = new WinningCount(new int[]{0, 0, 0, 0, 0, 1, 0});

    @Test
    void getWinningRate() {
        assertThat(winningCount.calculateWinningRate())
                .isEqualTo((float) Prize.getPrice(5) / Ticket.LOTTO_PRICE);
    }

    @Test
    void getCount() {
        assertAll(
                () -> assertThat(winningCount.countOfMatchCount(0)).isEqualTo(0),
                () -> assertThat(winningCount.countOfMatchCount(1)).isEqualTo(0),
                () -> assertThat(winningCount.countOfMatchCount(2)).isEqualTo(0),
                () -> assertThat(winningCount.countOfMatchCount(3)).isEqualTo(0),
                () -> assertThat(winningCount.countOfMatchCount(4)).isEqualTo(0),
                () -> assertThat(winningCount.countOfMatchCount(5)).isEqualTo(1),
                () -> assertThat(winningCount.countOfMatchCount(6)).isEqualTo(0)
        );
    }
}