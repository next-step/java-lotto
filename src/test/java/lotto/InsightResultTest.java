package lotto;

import lotto.domain.InsightResult;
import lotto.domain.RankEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class InsightResultTest {
    private Map<RankEnum, Integer> results = new HashMap<>();

    @BeforeEach
    void setUp() {
        results.put(RankEnum.FIRST, 1);
        results.put(RankEnum.FIFTH, 1);
    }

    @Test
    @DisplayName("로또결과 생성 테스트")
    void createInsightResultTest() {
        InsightResult insightResult = new InsightResult(results);
    }

    @Test
    @DisplayName("로또 분석후 수익금 가져오기 테스트")
    void getTotalRevenueTest() {
        InsightResult insightResult = new InsightResult(results);

        assertThat(
                insightResult.getTotalRevenue()
        ).isEqualTo(RankEnum.FIRST.getReward() + RankEnum.FIFTH.getReward());
    }
}
