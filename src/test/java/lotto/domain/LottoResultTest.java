package lotto.domain;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("결과 배열 확인")
    void rankResult() {
        // given
        Integer purchasePrice = 14000;
        LottoTickets lottoTickets = new LottoTickets(new PurchasePrice(purchasePrice));
        LottoTickets pickedLottoTickets = lottoTickets.pickNumbers();
        LottoTickets rankedLottoTickets = pickedLottoTickets.putRankings(List.of(1, 2, 3, 4, 5, 6));

        // when
        List<Rank> rankList = new LottoResult().rankResult(rankedLottoTickets);

        // then
        assertThat(rankList).hasSize(14);
    }

    @Test
    @DisplayName("수익률 확인")
    void yieldResult() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoTickets pickedLottoTickets = new LottoTickets(new PurchasePrice(14000), List.of(lotto));
        LottoTickets rankedLottoTickets = pickedLottoTickets.putRankings(List.of(1, 2, 3, 4, 5, 6));

        // when
        Integer integer = new LottoResult().yieldResult(rankedLottoTickets);

        // then
        assertThat(integer).isEqualTo(2000000);
    }
}
