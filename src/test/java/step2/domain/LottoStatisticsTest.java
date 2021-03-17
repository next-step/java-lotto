package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {


    @DisplayName("총수익이 0이면 0이다.")
    @Test
    void ZeroProfit() {
        //given
        Money paymentMoney = new Money(1000);
        List<Integer> matchResult = List.of(0, 0, 0);

        //when
        LottoStatistics lottoStatistics = new LottoStatistics(matchResult, paymentMoney);

        //then
        assertThat(lottoStatistics.getEarningRate()).isEqualTo(0.00);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void statistics_수익률() {
        //given
        Money paymentMoney = new Money(2000);
        List<Integer> matchResult = List.of(4, 0, 0);

        //when
        LottoStatistics lottoStatistics = new LottoStatistics(matchResult, paymentMoney);

        //then
        assertThat(lottoStatistics.getEarningRate()).isEqualTo(25.00);
    }

    @DisplayName("매칭된 로또들을 그룹화한다.")
    @Test
    void matchOfLotto_계산() {
        //given
        Money paymentMoney = new Money(1000);
        List<Integer> matchResult = List.of(5, 5, 6, 6, 4, 4);
        LottoStatistics lottoStatistics = new LottoStatistics(matchResult, paymentMoney);
        List<Boolean> matchOfBonus = List.of(true, false, true, false, true, false);

        //when
        Map<Integer, Long> matchGroup = lottoStatistics.statistics(matchOfBonus);

        //then
        assertThat(matchGroup.get(2_000_000_000)).isEqualTo(2);
        assertThat(matchGroup.get(30_000_000)).isEqualTo(1);
        assertThat(matchGroup.get(1_500_000)).isEqualTo(1);
        assertThat(matchGroup.get(50_000)).isEqualTo(2);
    }

}