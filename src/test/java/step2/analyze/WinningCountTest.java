package step2.analyze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.game.Ticket;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningCountTest {
    private static WinningCount winningCount;

    @BeforeEach
    void setUp() {
        winningCount = new WinningCount();
        winningCount.addCount(Prize.KRW_1_500_000);
    }

    @Test
    void getWinningRate() {
        assertThat(winningCount.calculateWinningRate()).isEqualTo(( float ) Prize.of(5, false).getMoney() / Ticket.LOTTO_PRICE);
    }

    @Test
    void getCount() {
        assertAll(() -> assertThat(winningCount.countOfPrize(Prize.KRW_0_000)).isEqualTo(0), () -> assertThat(winningCount.countOfPrize(Prize.KRW_5_000)).isEqualTo(0), () -> assertThat(winningCount.countOfPrize(Prize.KRW_50_000)).isEqualTo(0), () -> assertThat(winningCount.countOfPrize(Prize.KRW_1_500_000)).isEqualTo(1), () -> assertThat(winningCount.countOfPrize(Prize.KRW_30_000_000)).isEqualTo(0), () -> assertThat(winningCount.countOfPrize(Prize.KRW_2_000_000_000)).isEqualTo(0));
    }
}