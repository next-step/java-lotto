package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultServiceTest {

    @Test
    @DisplayName("결과 배열 확인")
    void rankResult() {
        // given
        Integer purchasePrice = 14000;
        LottoExchangeService lottoExchangeService = new LottoExchangeService();
        LottoTickets lottoTickets = lottoExchangeService.purchaseLottoTickets(purchasePrice);
        LottoTickets pickedLottoTickets = lottoTickets.pickNumbers();
        LottoTickets rankedLottoTickets = pickedLottoTickets.putRankings(List.of(1, 2, 3, 4, 5, 6));

        // when
        List<Rank> rankList = new LottoResultService().rankResult(rankedLottoTickets);

        // then
        assertThat(rankList).hasSize(14);
    }

    @Test
    @DisplayName("수익률 확인")
    void yieldResult() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoTickets pickedLottoTickets = new LottoTickets(1, 1000, List.of(lotto));
        LottoTickets rankedLottoTickets = pickedLottoTickets.putRankings(List.of(1, 2, 3, 4, 5, 6));

        // when
        Integer integer = new LottoResultService().yieldResult(rankedLottoTickets);

        // then
        assertThat(integer).isEqualTo(2000000);
    }
}
