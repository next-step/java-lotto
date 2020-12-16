package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoResult;
import step2.domain.LottoTier;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        Map<LottoTier, Integer> resultMap = new HashMap<>();

        resultMap.put(LottoTier.FIRST, 1);      // 2_000_000_000
        resultMap.put(LottoTier.SECOND, 1);     // 1_500_000
        resultMap.put(LottoTier.THIRD, 1);      // 50_000
        resultMap.put(LottoTier.FOURTH, 1);     // 5_000
        resultMap.put(LottoTier.NONE, 1);       // 0

        lottoResult = new LottoResult(resultMap);
    }

    @Test
    @DisplayName("총 수익금액을 계산한다.")
    void getTotalPrize() {
        assertThat(lottoResult.getTotalPrize()).isEqualTo(2001555000);
    }

    @Test
    @DisplayName("Tier를 입력받아, 당첨된 개수를 반환한다.")
    void getTierCount() {
        assertThat(lottoResult.getTierCount(LottoTier.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("구매금액을 입력받아 수익률을 계산한다.")
    void getYield() {
        assertThat(lottoResult.getYield(5000)).isEqualTo(400311);
    }
}
