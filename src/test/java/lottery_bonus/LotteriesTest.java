package lottery_bonus;

import lottery_bonus.domain.Lotteries;
import lottery_bonus.domain.Lottery;
import lottery_bonus.domain.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {
    private Lotteries lotteries;

    @BeforeEach
    void setUp() {
        lotteries = new Lotteries(
                Arrays.asList(
                        new Lottery(Arrays.asList(1, 2, 3, 4, 14, 15)),
                        new Lottery(Arrays.asList(7, 8, 9, 10, 11, 12))
                ));
    }

    @Test
    @DisplayName("로또 카운트 테스트")
    void count() {
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lotteries.drawWinningResult(winningNumber, 10))
                .isInstanceOf(WinningResult.class);
    }
}
