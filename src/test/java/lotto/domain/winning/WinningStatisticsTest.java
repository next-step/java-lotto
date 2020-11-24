package lotto.domain.winning;

import lotto.domain.Lottos;
import lotto.domain.SeedMoney;
import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created By mand2 on 2020-11-20.
 */
class WinningStatisticsTest {

    Lottos lottos;
    private final static int MONEY = SeedMoney.MONEY_PER_ROUND;
    SeedMoney seedMoney;

    @BeforeEach

    void setUp() {
        Lotto lotto1 = Lotto.of(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = Lotto.of(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 16)));
        Lotto lotto3 = Lotto.of(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 25, 26)));
        Lotto lotto4 = Lotto.of(LottoNumber.of(Arrays.asList(1, 2, 3, 34, 35, 36)));

        lottos = Lottos.of(Arrays.asList(lotto1, lotto2, lotto3, lotto4));
        seedMoney = SeedMoney.from(lottos.list().size() * MONEY);
    }

    @Test
    @DisplayName("내가 구매한 로또의 당첨통계를 구한다")
    void get_winning_statistics_of_lotto_bought() {
        // given
        WinningNumber winningNumber = WinningNumber.of("1, 2, 3, 4, 5, 6");
        int expectedPrize = WinningRank.FIRST.getPrize() * 1
                + WinningRank.THIRD.getPrize() * 1
                + WinningRank.FOURTH.getPrize() * 1
                + WinningRank.FIFTH.getPrize() * 1;
        double expectedStats = expectedPrize / (double) seedMoney.amount();

        // when
        WinningStatistics winningStatistics = WinningChecker.of(winningNumber).winningStatistics(lottos);

        // then
        assertThat(winningStatistics.earningRatio(seedMoney.amount()))
                .isEqualTo(expectedStats);

    }

}
