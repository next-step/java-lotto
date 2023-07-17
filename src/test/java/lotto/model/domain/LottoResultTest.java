package lotto.model.domain;


import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoResultTest {

    @Test
    void 로또_당첨결과_객체_생성_성공() {
        assertDoesNotThrow(() -> LottoResult.of(Ranks.of(List.of()), LottoMoney.valueOf(1000)));
    }

    @Test
    void 로또_당첨결과가_올바르게_저장_성공() {
        // given
        final Ranks ranks = Ranks.of(List.of(Rank.SECOND, Rank.FOURTH, Rank.SECOND));
        final LottoMoney purchase = LottoMoney.valueOf(3000);
        final LottoResult lottoResult = LottoResult.of(ranks, purchase);

        // when & then
        assertThat(lottoResult.getCount(Rank.SECOND)).isEqualTo(2);
        assertThat(lottoResult.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.getCount(Rank.FIRST)).isZero();
    }

    @Test
    void 로또_결과로_수익률_계산_성공() {
        // given
        final Ranks ranks = Ranks.of(List.of(Rank.SECOND, Rank.FOURTH, Rank.SECOND));
        final LottoMoney lottoMoney = LottoMoney.valueOf(3000);
        final LottoResult lottoResult = LottoResult.of(ranks, lottoMoney);

        // when
        final double profitRate = lottoResult.getProfitRate().getValue();

        // then
        final long totalPrize = Rank.SECOND.getTotalPrize(2) + Rank.FOURTH.getTotalPrize(1);
        assertThat(profitRate).isCloseTo(totalPrize / (double) lottoMoney.getValue(), Percentage.withPercentage(99));
    }
}
