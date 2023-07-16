package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 로또_당첨결과_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(
                () -> new LottoResult(new RankResults(List.of()), new LottoMoney(1000)));
    }

    @Test
    void 로또_당첨결과가_올바르게_저장_성공() {
        // given
        LottoResult lottoResult = new LottoResult(
                new RankResults(List.of(Rank.SECOND, Rank.FOURTH, Rank.SECOND)),
                new LottoMoney(3000));

        // when & then
        assertThat(lottoResult.getCount(Rank.SECOND)).isEqualTo(2);
        assertThat(lottoResult.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.getCount(Rank.FIRST)).isZero();
    }

    @Test
    void 로또_결과로_수익률_계산_성공() {
        // given
        LottoMoney lottoMoney = new LottoMoney(3000);
        LottoResult lottoResult = new LottoResult(
                new RankResults(List.of(Rank.SECOND, Rank.FOURTH, Rank.SECOND)),
                lottoMoney);

        // when
        double profitRate = lottoResult.getProfitRate();

        // then
        final long totalPrize =
                Rank.SECOND.getTotalPrize(2) + Rank.FOURTH.getTotalPrize(1);
        assertThat(profitRate).isCloseTo(totalPrize / (double) lottoMoney.getValue(),
                Percentage.withPercentage(99));
    }
}
