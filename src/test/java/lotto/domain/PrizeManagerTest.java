package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeManagerTest {

    @Test
    void 수익률_구하기() {
        Map<LottoRank, Integer> results = new HashMap<>();
        results.put(LottoRank.THREE_MATCH, 1);
        results.put(LottoRank.FOUR_MATCH, 0);
        results.put(LottoRank.FIVE_MATCH, 0);
        results.put(LottoRank.SIX_MATCH, 0);

        double profitMargin = new PrizeManager(results).getProfitMargin(10000);

        assertThat(profitMargin).isEqualTo(0.5);
    }
}