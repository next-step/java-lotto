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
        List<LottoPrize> lottoPrizes = List.of(LottoPrize.RANK1, LottoPrize.RANK2, LottoPrize.RANK3, LottoPrize.RANK4, LottoPrize.RANK5);
        LottoResult lottoResult = new LottoResult(lottoPrizes);
        Map<LottoPrize, Integer> matchesResult = lottoResult.getMatchesResult();

        matchesResult.forEach(((lottoPrize, integer) -> {
            assertThat(integer).isEqualTo(1);
        }));
    }

    @DisplayName("로또 수익률을 계산할 수 있다")
    @Test
    void rate() {
        LottoResult rank5 = new LottoResult(List.of(LottoPrize.RANK5));
        int purchaseCount = 14;
        double rate = rank5.calculateRate(purchaseCount);

        assertThat(rate).isEqualTo((double) 5000 / 14000);
    }

    @DisplayName("로또 총 당첨금을 계산할 수 있다")
    @Test
    void totalPrize() {
        LottoResult rank5 = new LottoResult(List.of(LottoPrize.RANK5));
        long totalPrize = rank5.calculateTotalPrize();

        assertThat(totalPrize).isEqualTo(5000);
    }
}
