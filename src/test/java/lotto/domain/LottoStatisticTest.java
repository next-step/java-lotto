package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticTest {

    @Test
    @DisplayName("수익률 계산하기")
    void calculateProfit() {
        Map<LottoRank, Integer> lottoStatisticMap = new HashMap<>();
        lottoStatisticMap.put(LottoRank.FOURTH, 1);
        LottoStatistic statistic = new LottoStatistic(lottoStatisticMap);
        double profit = statistic.calculateProfit(14_000);
        assertThat(profit).isEqualTo(0.35);
    }
}
