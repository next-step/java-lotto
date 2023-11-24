package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.domain.LottoProfit;
import step2.domain.LottoResult;

import java.util.HashMap;
import java.util.Map;

class LottoProfitTest {

    @Test
    void profit() {

        Map<LottoRank, Integer> result = new HashMap<>();
        result.put(LottoRank.FIRST, 0);
        result.put(LottoRank.SECOND, 0);
        result.put(LottoRank.THIRD, 0);
        result.put(LottoRank.FOURTH, 0);
        result.put(LottoRank.FIFTH, 2);
        result.put(LottoRank.NONE, 0);

        Assertions.assertThat(new LottoProfit().profit(5000, new LottoResult(result))).isEqualTo(2.0);
    }
}