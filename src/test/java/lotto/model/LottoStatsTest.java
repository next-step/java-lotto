package lotto.model;

import common.model.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatsTest {

    LottoStats lottoStats;

    @BeforeEach
    void setUp() {
        Map<LottoRank, Number> lottoRankNumberMap = new HashMap<>();
        lottoRankNumberMap.put(LottoRank.FOURTH, new Number(1));
        lottoRankNumberMap.put(LottoRank.THIRD, new Number(1));

        lottoStats = new LottoStats(lottoRankNumberMap, 2000);
    }

    @Test
    @DisplayName("당첨 통계 수익률 테스트")
    void rateOfRevenue() {
        assertThat(lottoStats.getRateOfRevenue()).isEqualTo(27.5F);
    }

}