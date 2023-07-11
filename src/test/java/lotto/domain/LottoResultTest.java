package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult result;

    @BeforeEach
    void setUp() {
        Map<LottoRank, Long> rankResult = new HashMap<>();
        rankResult.put(LottoRank.FIRST, 3L);
        rankResult.put(LottoRank.SECOND, 2L);
        rankResult.put(LottoRank.THIRD, 1L);
        rankResult.put(LottoRank.FOURTH, 4L);
        rankResult.put(LottoRank.FIFTH, 12L);
        rankResult.put(LottoRank.NONE, 15L);

        result = new LottoResult(rankResult);
    }

    @Test
    @DisplayName("총 상금 계산")
    void calculateTotalPrizeTest() {
        //when
        Money totalPrize = result.calculateTotalPrize();

        //then
        assertThat(totalPrize).isEqualTo(new Money(6_061_760_000L));
    }

    @Test
    @DisplayName("수익률 계산 기능 테스트")
    void calculateYield() {
        //when, then
        assertThat(result.calculateYield()).isEqualTo(163831.35135135136);
    }
}