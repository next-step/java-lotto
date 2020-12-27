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

        SortedMap<LottoRank, Integer> expectedLottoStatisticMap = new TreeMap<>();
        expectedLottoStatisticMap.put(LottoRank.FIRST, 1);
        expectedLottoStatisticMap.put(LottoRank.THIRD, 2);
        expectedLottoStatisticMap.put(LottoRank.FOURTH, 3);
        expectedLottoStatisticMap.put(LottoRank.FIFTH, 2);
        //lottoStatisticMap.put(LottoRank.MISS, 3);
        LottoStatistic expected = new LottoStatistic(expectedLottoStatisticMap);

        // then
        //actual.toFormattingStringList().forEach(System.out::println);
        assertThat(actual).isEqualTo(expected);

    }

}
