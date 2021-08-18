package lotto.step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoStatisticsTest {

    Winning winning;

    @BeforeEach
        // 당첨 번호 = {21,22,23,24,25,26} , 보너스 볼 30
    void init() {
        List<LottoNumber> winningNumber
                = Arrays.asList(new LottoNumber(21), new LottoNumber(22), new LottoNumber(23), new LottoNumber(24), new LottoNumber(25), new LottoNumber(26));
        winning = new Winning(new Lottery(new HashSet<>(winningNumber)), new LottoNumber(30));
    }

    @Test
    @DisplayName("로또 2장 : 5등 1개 , 4등 1개")
    void calculateLottoStatistics() {
        Lottery lottery1 = new Lottery(new HashSet<>(
                Arrays.asList(new LottoNumber(21), new LottoNumber(22), new LottoNumber(32), new LottoNumber(24), new LottoNumber(5), new LottoNumber(6)))
        );
        Lottery lottery2 = new Lottery(new HashSet<>(
                Arrays.asList(new LottoNumber(21), new LottoNumber(22), new LottoNumber(3), new LottoNumber(14), new LottoNumber(25), new LottoNumber(26)))
        );
        Lotteries lotteries = new Lotteries(Arrays.asList(lottery1, lottery2));
        LottoStatistics lottoStatistics = lotteries.compareLottoWith(winning);
        double earningRate = lottoStatistics.calculateLottoStatistics(2000);
        assertThat(earningRate).isEqualTo(27.5);
    }

    @Test
    @DisplayName("로또 3장 : 1등 3개")
    void calculateLottoStatistics2() {
        Lottery lottery1 = new Lottery(new HashSet<>(
                Arrays.asList(new LottoNumber(21), new LottoNumber(22), new LottoNumber(23), new LottoNumber(24), new LottoNumber(25), new LottoNumber(26)))
        );
        Lottery lottery2 = new Lottery(new HashSet<>(Arrays.asList(
                new LottoNumber(21), new LottoNumber(22), new LottoNumber(23), new LottoNumber(26), new LottoNumber(25), new LottoNumber(24)))
        );
        Lottery lottery3 = new Lottery(new HashSet<>(Arrays.asList(
                new LottoNumber(21), new LottoNumber(22), new LottoNumber(25), new LottoNumber(23), new LottoNumber(24), new LottoNumber(26)))
        );
        Lotteries lotteries = new Lotteries(Arrays.asList(lottery1, lottery2, lottery3));
        LottoStatistics lottoStatistics = lotteries.compareLottoWith(winning);
        double earningRate = lottoStatistics.calculateLottoStatistics(3000);
        assertThat(earningRate).isEqualTo(666666.66);
    }

    @Test
    @DisplayName("로또 3장 : 3등 1개 , 2등 1개 , 꽝 1개")
    void calculateLottoStatistics3() {
        Lottery lottery1 = new Lottery(new HashSet<>(Arrays.asList(
                new LottoNumber(21), new LottoNumber(22), new LottoNumber(23), new LottoNumber(24), new LottoNumber(25), new LottoNumber(6)))
        );
        Lottery lottery2 = new Lottery(new HashSet<>(Arrays.asList(
                new LottoNumber(21), new LottoNumber(22), new LottoNumber(23), new LottoNumber(24), new LottoNumber(25), new LottoNumber(30)))
        );
        Lottery lottery3 = new Lottery(new HashSet<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(14), new LottoNumber(25), new LottoNumber(26)))
        );
        Lotteries lotteries = new Lotteries(Arrays.asList(lottery1, lottery2, lottery3));
        LottoStatistics lottoStatistics = lotteries.compareLottoWith(winning);
        double earningRate = lottoStatistics.calculateLottoStatistics(3000);
        assertThat(earningRate).isEqualTo(10500.0);
    }

    @Test
    @DisplayName("로또 5장 : 3등 1개 ,꽝 4개")
    void calculateLottoStatistics4() {
        Lottery lottery1 = new Lottery(new HashSet<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))
        );
        Lottery lottery2 = new Lottery(new HashSet<>(Arrays.asList(
                new LottoNumber(40), new LottoNumber(41), new LottoNumber(42), new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)))
        );
        Lottery lottery3 = new Lottery(new HashSet<>(Arrays.asList(
                new LottoNumber(31), new LottoNumber(32), new LottoNumber(33), new LottoNumber(14), new LottoNumber(35), new LottoNumber(26)))
        );
        Lottery lottery4 = new Lottery(new HashSet<>(Arrays.asList(
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(33), new LottoNumber(14), new LottoNumber(35), new LottoNumber(16)))
        );
        Lottery lottery5 = new Lottery(new HashSet<>(Arrays.asList(
                new LottoNumber(10), new LottoNumber(22), new LottoNumber(23), new LottoNumber(24), new LottoNumber(25), new LottoNumber(26)))
        );
        Lotteries lotteries = new Lotteries(Arrays.asList(lottery1, lottery2, lottery3, lottery4, lottery5));
        LottoStatistics lottoStatistics = lotteries.compareLottoWith(winning);
        double earningRate = lottoStatistics.calculateLottoStatistics(5000);
        assertThat(earningRate).isEqualTo(300.00);
    }


}