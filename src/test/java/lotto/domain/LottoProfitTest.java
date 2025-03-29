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
        HashMap<LottoPrize, Integer> ranks = new HashMap<>();
        ranks.put(LottoPrize.FIFTH, 1);
        int totalCount = 14;

        // when
        LottoProfit lottoProfit = new LottoProfit(ranks, totalCount);

        // then
        assertThat(lottoProfit.getProfitRate()).isEqualTo(0.35);
    }

    @DisplayName("2등 당첨 통계 테스트")
    @Test
    void secondRankProfitTest() {
        // given
        HashMap<LottoPrize, Integer> ranks = new HashMap<>();
        ranks.put(LottoPrize.SECOND, 1);
        int totalCount = 14;

        // when
        LottoProfit lottoProfit = new LottoProfit(ranks, totalCount);

        // then
        // NOTE. 14_000원 투자해서 30_000_000 받았으면 수익률은
        assertThat(lottoProfit.getProfitRate()).isEqualTo(2142.85);
    }
}
