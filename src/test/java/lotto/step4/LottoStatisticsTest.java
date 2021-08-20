package lotto.step4;

import lotto.step4.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    Winning winning;

    @BeforeEach

    void init() {
        List<LottoNumber> winningNumber
                = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Lottery lottery = new Lottery(winningNumber);
        winning = new Winning(lottery , new LottoNumber(7));
    } // 당첨 번호 = {1,2,3,4,5,6} , 보너스 볼 7

    @Test
    @DisplayName("1등 1개 5등 3개")
    void RankCountTest() {
        Lottery lottery = new Lottery(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))); // 1등
        Lottery lottery1 = new Lottery(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)));// 5등
        Lottery lottery2 = new Lottery(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(24), new LottoNumber(25), new LottoNumber(26))); // 5등
        Lottery lottery3 = new Lottery(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(44), new LottoNumber(35), new LottoNumber(16)));// 5등
        Lotteries lotteries = new Lotteries(Arrays.asList(lottery1, lottery2, lottery3, lottery));
        LottoStatistics lottoStatistics = lotteries.compareLottoWith(winning);
        assertThat(lottoStatistics.count(Rank.FIFTH)).isEqualTo(3);
        assertThat(lottoStatistics.count(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등 2개 3등 1개")
    void RankCountTest2() {
        LottoStatistics lottoStatistics = new LottoStatistics(Arrays.asList(Rank.SECOND, Rank.SECOND, Rank.THIRD));
        assertThat(lottoStatistics.count(Rank.SECOND)).isEqualTo(2);
        assertThat(lottoStatistics.count(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoStatistics.count(Rank.FIRST)).isEqualTo(0);
    }

    @Test
    @DisplayName("3등 1개 4등 3개")
    void RankCountTest3() {
        Lottery lottery = new Lottery(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(15), new LottoNumber(16))); // 4등
        Lottery lottery1 = new Lottery(Arrays.asList(new LottoNumber(11), new LottoNumber(12), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));// 4등
        Lottery lottery2 = new Lottery(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(25), new LottoNumber(26))); // 4등
        Lottery lottery3 = new Lottery(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(16)));// 3등
        Lotteries lotteries = new Lotteries(Arrays.asList(lottery1, lottery2, lottery3, lottery));
        LottoStatistics lottoStatistics = lotteries.compareLottoWith(winning);
        assertThat(lottoStatistics.count(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoStatistics.count(Rank.FOURTH)).isEqualTo(3);
        assertThat(lottoStatistics.count(Rank.FIFTH)).isEqualTo(0);
    }

}