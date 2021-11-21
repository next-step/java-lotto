package lotto.model;

import common.model.Number;
import common.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoStatsTest {

    LottoStats lottoStats;

    @BeforeEach
    void setUp() {
        Map<LottoRank, Number> lottoRankNumberMap = new HashMap<>();
        lottoRankNumberMap.put(LottoRank.FOURTH, new Number(5));
        lottoRankNumberMap.put(LottoRank.THIRD, new Number(2));

        lottoStats = new LottoStats(lottoRankNumberMap, 1200);
    }

    @Test
    @DisplayName("당첨 통계 수익률 테스트")
    void rateOfRevenue(){
        float rateOfRevenue = lottoStats.calculateRateOfRevenue(2400F);

        assertThat(rateOfRevenue).isEqualTo(2F);
    }

}