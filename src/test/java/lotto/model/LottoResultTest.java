package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 결과_계산() {
        LottoResult lottoResult = new LottoResult(
                List.of(
                        LottoPrize.FIRST,
                        LottoPrize.SECOND,
                        LottoPrize.SECOND,
                        LottoPrize.THIRD,
                        LottoPrize.FOURTH,
                        LottoPrize.FIFTH,
                        LottoPrize.FIFTH,
                        LottoPrize.NONE
                )
        );
        int profit = lottoResult.calculateProfit();

        assertThat(profit).isEqualTo(2_000_000_000 * 1 + 30_000_000 * 2 + 1_500_000 * 1 + 50_000 * 1 + 5_000 * 2 + 0 * 1);
    }

    @Test
    void 수익률_계산() {
        LottoResult lottoResult = new LottoResult(
                List.of(
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.FIFTH,
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.NONE
                )
        );
        double returnRate = lottoResult.calculateReturnRate();

        assertThat(returnRate).isEqualTo(0.35);
    }

    @Test
    void 상별_카운트() {
        LottoResult lottoResult = new LottoResult(
                List.of(
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.SECOND,
                        LottoPrize.SECOND,
                        LottoPrize.NONE,
                        LottoPrize.FIRST,
                        LottoPrize.NONE,
                        LottoPrize.THIRD,
                        LottoPrize.THIRD,
                        LottoPrize.THIRD,
                        LottoPrize.NONE,
                        LottoPrize.FOURTH,
                        LottoPrize.NONE,
                        LottoPrize.NONE,
                        LottoPrize.NONE
                )
        );
        assertThat(lottoResult.getPrizeCount(LottoPrize.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getPrizeCount(LottoPrize.SECOND)).isEqualTo(2);
        assertThat(lottoResult.getPrizeCount(LottoPrize.THIRD)).isEqualTo(3);
        assertThat(lottoResult.getPrizeCount(LottoPrize.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.getPrizeCount(LottoPrize.NONE)).isEqualTo(8);
    }

}
