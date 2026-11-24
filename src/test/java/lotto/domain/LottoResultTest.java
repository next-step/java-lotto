package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 등수별_당첨_개수를_집계한다() {
        List<Rank> ranks = List.of(Rank.FOURTH, Rank.FOURTH, Rank.FIRST, Rank.MISS);

        LottoResult result = new LottoResult(ranks, new PurchaseAmount(4000));

        assertThat(result.getCount(Rank.FOURTH)).isEqualTo(2);
        assertThat(result.getCount(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void 당첨되지_않은_등수는_0개로_반환한다() {
        LottoResult result = new LottoResult(List.of(Rank.FOURTH), new PurchaseAmount(1000));

        assertThat(result.getCount(Rank.SECOND)).isZero();
    }

    @Test
    void 총_당첨_금액을_계산한다() {
        List<Rank> ranks = List.of(Rank.FOURTH, Rank.FOURTH, Rank.THIRD, Rank.MISS);

        LottoResult result = new LottoResult(ranks, new PurchaseAmount(4000));

        assertThat(result.getTotalPrize()).isEqualTo(60_000L);
    }

    @Test
    void 수익률은_총_당첨_금액을_실제_사용_금액으로_나눈_값이다() {
        List<Rank> ranks = List.of(Rank.THIRD, Rank.FOURTH, Rank.FOURTH, Rank.MISS);

        LottoResult result = new LottoResult(ranks, new PurchaseAmount(4500));

        assertThat(result.getProfitRate()).isEqualTo(15.0);
    }

    @Test
    void 수익률은_소수점_둘째_자리까지_버림_처리한다() {
        List<Rank> ranks = new ArrayList<>(Collections.nCopies(13, Rank.MISS));
        ranks.add(Rank.FOURTH);

        LottoResult result = new LottoResult(ranks, new PurchaseAmount(14000));

        assertThat(result.getProfitRate()).isEqualTo(0.35);
    }
}
