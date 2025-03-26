package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitTest {
    @DisplayName("투입 금액 대비 로또 수익률을 계산할 수 있다.")
    @Test
    void profitTest() {
        // given
        HashMap<Integer, Integer> ranks = new HashMap<>();
        ranks.put(3, 1);
        int totalCount = 14;

        // when
        Double profit = LottoProfit.calculate(ranks, totalCount);

        // then
        assertThat(profit).isEqualTo(0.35);
    }
}
