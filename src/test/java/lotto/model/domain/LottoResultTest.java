package lotto.model.domain;


import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoResultTest {

    @Test
    void 로또_당첨결과_객체_생성_성공() {
        assertDoesNotThrow(() -> LottoResult.of(List.of(), Money.valueOf(1000)));
    }

    @Test
    void 로또_당첨결과가_올바르게_저장_성공() {
        // given
        final List<Rank> ranks = List.of(Rank.SECOND, Rank.FOURTH, Rank.SECOND);
        final Money purchase = Money.valueOf(3000);
        final LottoResult lottoResult = LottoResult.of(ranks, purchase);

        // when & then
        assertThat(lottoResult.getCount(Rank.SECOND)).isEqualTo(2);
        assertThat(lottoResult.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.getCount(Rank.FIRST)).isZero();
    }

    @Test
    void 로또_결과로_수익률_계산_성공() {
        // given
        final List<Rank> ranks = List.of(Rank.SECOND, Rank.FOURTH, Rank.SECOND);
        final Money money = Money.valueOf(3000);
        final LottoResult lottoResult = LottoResult.of(ranks, money);

        // when
        final double profitRate = lottoResult.getProfitRate();

        // then
        final long totalPrize = Rank.getTotalPrize(Rank.SECOND, 2) + Rank.getTotalPrize(Rank.FOURTH, 1);
        assertThat(profitRate).isCloseTo(totalPrize / (double) money.getValue(), Percentage.withPercentage(99));
    }
}
