package lotto;

import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("당첨개수에 따라 당첨 결과를 계산할 수 있다")
    @Test
    void result() {
        LottoResult lottoResult = new LottoResult(List.of(6, 5, 4, 3));
        Map<LottoPrize, Integer> matchesResult = lottoResult.getMatchesResult();

        matchesResult.forEach(((lottoPrize, integer) -> {
            assertThat(integer).isEqualTo(1);
        }));
    }

    @DisplayName("로또 수익률을 계산할 수 있다")
    @Test
    void rate() {
        LottoResult lottoResult = new LottoResult(List.of(3));
        int purchaseCount = 14;
        double rate = lottoResult.calculateRate(purchaseCount);

        assertThat(rate).isEqualTo((double) 5000 / 14000);
    }

    @DisplayName("로또 총 당첨금을 계산할 수 있다")
    @Test
    void totalPrize() {
        LottoResult lottoResult = new LottoResult(List.of(3));
        long totalPrize = lottoResult.calculateTotalPrize();

        assertThat(totalPrize).isEqualTo(5000);
    }
}
