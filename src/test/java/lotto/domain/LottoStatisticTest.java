package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticTest {

    @Test
    @DisplayName("수익률 계산하기")
    void calculateProfit() {
        SortedMap<LottoRank, Integer> lottoStatisticMap = new TreeMap<>();
        lottoStatisticMap.put(LottoRank.FOURTH, 1);
        LottoStatistic statistic = new LottoStatistic(lottoStatisticMap);
        double profit = statistic.calculateProfit(14_000);
        assertThat(profit).isEqualTo(0.35);
    }
}
