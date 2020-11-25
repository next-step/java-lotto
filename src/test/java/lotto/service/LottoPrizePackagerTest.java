package lotto.service;

import lotto.domain.LottoBalls;
import lotto.domain.LottoNumber;
import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.WinningLottoBalls;
import lotto.domain.enums.PickType;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizePackagerTest {
    private final AbstractPrizePackager prizePackager = new LottoPrizePackager();
    private Pick testPick;

    @BeforeEach
    void makeTestPick(){
        testPick = new Pick(PickType.AUTO, new LottoBalls(1, 2, 3, 4, 5, 6));
    }

    @Test
    void testFirstPrize() {
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank first = prizeInfo.checkRank(testPick, new WinningLottoBalls(new LottoBalls(1, 2, 3, 4, 5, 6),new LottoNumber(7)));
        assertThat(first).isEqualTo(Rank.FIRST);
    }

    @Test
    void testThirdPrize() {
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank third = prizeInfo.checkRank(testPick, new WinningLottoBalls(new LottoBalls(1, 2, 3, 4, 5, 7), new LottoNumber(8)));
        assertThat(third).isEqualTo(Rank.THIRD);
    }

    @Test
    void testFourthPrize() {
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank fourth = prizeInfo.checkRank(testPick, new WinningLottoBalls(new LottoBalls(1, 2, 3, 4, 7, 8), new LottoNumber(10)));
        assertThat(fourth).isEqualTo(Rank.FOURTH);
    }

    @Test
    void testFifthPrize() {
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank fifth = prizeInfo.checkRank(testPick, new WinningLottoBalls(new LottoBalls(1, 2, 3, 7, 8, 9), new LottoNumber(10)));
        assertThat(fifth).isEqualTo(Rank.FIFTH);
    }

    @Test
    void testLosePrize() {
        PrizeInfo prizeInfo = prizePackager.pack();
        Rank lose = prizeInfo.checkRank(testPick, new WinningLottoBalls(new LottoBalls(1, 2, 7, 8, 9, 10), new LottoNumber(20)));
        assertThat(lose).isNull();
    }
}
