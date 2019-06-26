package step3.iksoo.lotto2rd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {
    private final int PRIZE_AMT = 30_055_000;

    MatchResult matchResult;

    @BeforeEach
    void setUp() {
        Lottoes lottoes = new Lottoes(0);
        lottoes.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoes.add(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
        lottoes.add(new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)));
        matchResult = new MatchResult(lottoes.checkLotteryWin(Arrays.asList(4, 5, 6, 7, 8, 10), 9));
    }

    @Test
    void 로또수익률() {
        assertThat(matchResult.calculateRateProfit(3000)).isEqualTo((double) PRIZE_AMT / 3000);
    }

    @Test
    void 로또_당첨금() {
        assertThat(matchResult.calculatePrize()).isEqualTo(PRIZE_AMT);
    }
}
