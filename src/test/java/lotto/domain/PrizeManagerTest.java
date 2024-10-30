package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeManagerTest {

    @Test
    void 수익률_구하기() {
        Map<Integer, Integer> results = new HashMap<>();
        results.put(3, 1);
        results.put(4, 0);
        results.put(5, 0);
        results.put(6, 0);

        double profitMargin = new PrizeManager(results).getProfitMargin(10000);

        assertThat(profitMargin).isEqualTo(0.5);
    }
}