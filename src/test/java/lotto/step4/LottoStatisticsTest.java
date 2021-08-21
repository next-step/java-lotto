package lotto.step4;

import lotto.step4.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoStatisticsTest {

    Winning winning;

    @BeforeEach
    void init() {
        List<LottoNumber> winningNumber
                = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
        Lottery lottery = new Lottery(winningNumber);
        winning = new Winning(lottery, LottoNumber.of(7));
    } // 당첨 번호 = {1,2,3,4,5,6} , 보너스 볼 7

    @Test
    @DisplayName("1등 1개 5등 3개")
    void RankCountTest() {
        Lottery lottery = new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))); // 1등
        Lottery lottery1 = new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(14), LottoNumber.of(15), LottoNumber.of(16)));// 5등
        Lottery lottery2 = new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(24), LottoNumber.of(25), LottoNumber.of(26))); // 5등
        Lottery lottery3 = new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(44), LottoNumber.of(35), LottoNumber.of(16)));// 5등
        Lotteries lotteries = new Lotteries(Arrays.asList(lottery1, lottery2, lottery3, lottery));
        LottoStatistics lottoStatistics = lotteries.compareLottoWith(winning);
        assertAll(
                () -> assertThat(lottoStatistics.count(Rank.FIFTH)).isEqualTo(3),
                () -> assertThat(lottoStatistics.count(Rank.FIRST)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("2등 2개 3등 1개")
    void RankCountTest2() {
        LottoStatistics lottoStatistics = new LottoStatistics(Arrays.asList(Rank.SECOND, Rank.SECOND, Rank.THIRD));
        assertAll(
                () -> assertThat(lottoStatistics.count(Rank.SECOND)).isEqualTo(2),
                () -> assertThat(lottoStatistics.count(Rank.THIRD)).isEqualTo(1),
                () -> assertThat(lottoStatistics.count(Rank.FIRST)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("3등 1개 4등 3개")
    void RankCountTest3() {
        Lottery lottery = new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(15), LottoNumber.of(16))); // 4등
        Lottery lottery1 = new Lottery(Arrays.asList(LottoNumber.of(11), LottoNumber.of(12), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));// 4등
        Lottery lottery2 = new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(25), LottoNumber.of(26))); // 4등
        Lottery lottery3 = new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(16)));// 3등
        Lotteries lotteries = new Lotteries(Arrays.asList(lottery1, lottery2, lottery3, lottery));
        LottoStatistics lottoStatistics = lotteries.compareLottoWith(winning);
        assertAll(
                () -> assertThat(lottoStatistics.count(Rank.THIRD)).isEqualTo(1),
                () -> assertThat(lottoStatistics.count(Rank.FOURTH)).isEqualTo(3),
                () -> assertThat(lottoStatistics.count(Rank.FIFTH)).isEqualTo(0)
        );

    }

    @Test
    @DisplayName("3등 1개 4등 3개의 상금")
    void LottoWinningSumTest() {
        Lottery lottery = new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(15), LottoNumber.of(16))); // 4등
        Lottery lottery1 = new Lottery(Arrays.asList(LottoNumber.of(11), LottoNumber.of(12), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));// 4등
        Lottery lottery2 = new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(25), LottoNumber.of(26))); // 4등
        Lottery lottery3 = new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(16)));// 3등
        Lotteries lotteries = new Lotteries(Arrays.asList(lottery1, lottery2, lottery3, lottery));
        LottoStatistics lottoStatistics = lotteries.compareLottoWith(winning);
        assertThat(lottoStatistics.reward()).isEqualTo(1650000);
    }

    @Test
    @DisplayName("수익률 계산")
    void calculateRate() {
        List<Lottery> lotteries = Arrays.asList(new Lottery(Arrays.asList(LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12))),
                new Lottery(Arrays.asList(LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12))),
                new Lottery(Arrays.asList(LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12))),
                new Lottery(Arrays.asList(LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12))),
                new Lottery(Arrays.asList(LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12))),
                new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12))));

        Lotteries lotteries1 = new Lotteries(lotteries);
        LottoStatistics lottoStatistics = lotteries1.compareLottoWith(winning);
        assertThat(lottoStatistics.calculateLottoStatistics()).isEqualTo(0.83);
    }

    @Test
    @DisplayName("수익률 계산")
    void calculateRate2() {
        List<Lottery> lotteries = Arrays.asList(new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(16))),
                new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(11), LottoNumber.of(12))),
                new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(21), LottoNumber.of(12))),
                new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12))),
                new Lottery(Arrays.asList(LottoNumber.of(27), LottoNumber.of(28), LottoNumber.of(19), LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12)))
        );

        Lotteries lotteries1 = new Lotteries(lotteries);
        LottoStatistics lottoStatistics = lotteries1.compareLottoWith(winning);
        assertThat(lottoStatistics.calculateLottoStatistics()).isEqualTo(321.0);
    }

}