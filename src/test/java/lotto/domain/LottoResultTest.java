package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {
    @Test
    @DisplayName("rank에 해당되는 개수를 반환한다.")
    void 둥수별개수() {
        LottoResult lottoResult = new LottoResult();

        lottoResult.put(Rank.FIRST);
        lottoResult.put(Rank.FIRST);

        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(2);
    }

    @Test
    @DisplayName("총 수익률을 계산한다.")
    void 총수익률() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.put(Rank.FIRST);

        assertThat(lottoResult.calculateProfitRate(LottoPurchaseAmount.of(1000))).isEqualTo(2000000000/1000);
    }
}
