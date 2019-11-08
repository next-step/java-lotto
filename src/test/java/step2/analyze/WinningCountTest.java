package step2.analyze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.game.Ticket;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningCountTest {
    private static WinningCount winningCount;

    @BeforeEach
    void setUp() {
        Map<Prize, Integer> winning = new HashMap<>();
        winning.put(Prize.KRW_1_500_000, 1);
        winningCount = new WinningCount(winning);
    }

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