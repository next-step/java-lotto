package lotto.service;

import lotto.domain.LottoBalls;
import lotto.domain.LottoNumber;
import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.WinningLottoBalls;
import lotto.domain.enums.PickType;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizePackagerTest {
    @Test
    void testAlwaysLose() {
        AbstractPrizePackager prizePackager = new DefaultPrizePackager();
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank rank = prizeInfo.checkRank(new Pick(PickType.AUTO, new LottoBalls(1, 2, 3, 4, 5, 6)), new WinningLottoBalls(new LottoBalls(1, 2, 3, 4, 5, 6), new LottoNumber(8)));

        assertThat(rank).isEqualTo(Rank.LOSE);

        Rank rank2 = prizeInfo.checkRank(new Pick(PickType.AUTO, new LottoBalls(1, 2, 3, 4, 5, 6)), new WinningLottoBalls(new LottoBalls(1, 2, 3, 4, 5, 7), new LottoNumber(8)));

        assertThat(rank2).isEqualTo(Rank.LOSE);
    }

    @Test
    void testAlwaysJackPot() {
        AbstractPrizePackager prizePackager = new JackPotPrizePackager();
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank rank = prizeInfo.checkRank(new Pick(PickType.AUTO, new LottoBalls(1, 2, 3, 4, 5, 6)), new WinningLottoBalls(new LottoBalls(1, 2, 3, 4, 5, 6), new LottoNumber(8)));

        assertThat(rank).isEqualTo(Rank.FIRST);

        Rank rank2 = prizeInfo.checkRank(new Pick(PickType.AUTO, new LottoBalls(1, 2, 3, 4, 5, 6)), new WinningLottoBalls(new LottoBalls(10, 11, 13, 14, 15, 16), new LottoNumber(30)));

        assertThat(rank2).isEqualTo(Rank.FIRST);
    }
}
