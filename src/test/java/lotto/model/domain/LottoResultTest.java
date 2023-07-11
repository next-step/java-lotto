package lotto.model.domain;


import lotto.model.domain.LottoMoney;
import lotto.model.domain.LottoResult;
import lotto.model.domain.Rank;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoResultTest {

    @Test
    void 로또_당첨결과_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> new LottoResult(List.of()));
    }

    @Test
    void 로또_당첨결과가_올바르게_저장_성공() {
        // given
        LottoResult lottoResult = new LottoResult(List.of(Rank.SECOND, Rank.FOURTH, Rank.SECOND));

        // when & then
        assertThat(lottoResult.getCount(Rank.SECOND)).isEqualTo(2);
        assertThat(lottoResult.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.getCount(Rank.FIRST)).isZero();
    }

    @Test
    void 로또_결과로_수익률_계산_성공() {
        // given
        LottoMoney lottoMoney = new LottoMoney(3000);
        LottoResult lottoResult = new LottoResult(List.of(Rank.SECOND, Rank.FOURTH, Rank.SECOND));

        // when
        double profitRate = lottoResult.calculateProfitRate(lottoMoney);

        // then
        final long totalPrize = Rank.getTotalPrize(Rank.SECOND, 2) + Rank.getTotalPrize(Rank.FOURTH, 1);
        assertThat(profitRate).isCloseTo(totalPrize / (double) lottoMoney.getValue(), Percentage.withPercentage(99));
    }
}
