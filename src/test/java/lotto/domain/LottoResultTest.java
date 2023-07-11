package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("총 상금 계산")
    void calculateTotalPrizeTest() {
        //given
        Map<LottoRank, Long> rankResult = new HashMap<>();
        rankResult.put(LottoRank.FIRST, 3L);
        rankResult.put(LottoRank.SECOND, 2L);
        rankResult.put(LottoRank.THIRD, 1L);
        rankResult.put(LottoRank.FOURTH, 4L);
        rankResult.put(LottoRank.FIFTH, 12L);
        rankResult.put(LottoRank.NONE, 15L);

        LottoResult result = new LottoResult(rankResult);

        //when
        Money totalPrize = result.calculateTotalPrize();

        //then
        assertThat(totalPrize).isEqualTo(new Money(6_061_760_000L));
    }
}