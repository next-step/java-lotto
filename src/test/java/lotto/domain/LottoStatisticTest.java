package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticTest {

    @Test
    @DisplayName("수익률 계산하기")
    void calculateProfit() {
        SortedMap<LottoRank, Integer> lottoStatisticMap = new TreeMap<>();
        lottoStatisticMap.put(LottoRank.FIFTH, 1);
        LottoStatistic statistic = new LottoStatistic(lottoStatisticMap);
        double profit = statistic.calculateProfit(14_000);
        assertThat(profit).isEqualTo(0.35);
    }

    @Test
    void putLottoStatisticMap() {

        // given
        LottoStatistic actual = new LottoStatistic();
        List<LottoRank> lottoRanks = Arrays.asList(
                LottoRank.FIRST,
                LottoRank.THIRD, LottoRank.THIRD,
                LottoRank.FOURTH, LottoRank.FOURTH, LottoRank.FOURTH,
                LottoRank.FIFTH, LottoRank.FIFTH,
                LottoRank.MISS, LottoRank.MISS, LottoRank.MISS
        );

        // when
        for (LottoRank rank : lottoRanks) {
            actual.putLottoStatisticMap(rank);
        }

        // then
        //actual.toFormattingStringList().forEach(System.out::println);
        assertThat(actual.getCountByRank(LottoRank.FIRST)).isEqualTo(1);
        assertThat(actual.getCountByRank(LottoRank.THIRD)).isEqualTo(2);
        assertThat(actual.getCountByRank(LottoRank.FOURTH)).isEqualTo(3);
        assertThat(actual.getCountByRank(LottoRank.FIFTH)).isEqualTo(2);
        assertThat(actual.getCountByRank(LottoRank.MISS)).isEqualTo(0);

    }

}
