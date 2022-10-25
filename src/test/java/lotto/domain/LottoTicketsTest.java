package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    @DisplayName("자동 추첨 수량 확인")
    void pick() {
        // given
        Integer purchasePrice = 14000;

        // when
        LottoTickets lottoTickets = new LottoTickets(new PurchasePrice(purchasePrice));
        LottoTickets autoPickLottoTickets = lottoTickets.pickNumbers();

        // then
        assertThat(autoPickLottoTickets.getLottoList()).hasSize(14);
    }

    @Test
    @DisplayName("랭킹 확인")
    void rank() {
        // given
        Integer purchasePrice = 14000;
        LottoResult winnerLottoResult = new LottoResult(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoTickets lottoTickets = new LottoTickets(new PurchasePrice(purchasePrice));
        LottoTickets pickedLottoTickets = lottoTickets.pickNumbers();
        List<Rank> rankList = pickedLottoTickets.putRankings(winnerLottoResult);

        // then
        assertThat(rankList).isNotNull();
    }

    @Test
    @DisplayName("랭킹 확인")
    void getRank() {
        // given
        Integer purchasePrice = 14000;
        LottoResult winnerLottoResult = new LottoResult(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoTickets lottoTickets = new LottoTickets(new PurchasePrice(purchasePrice));
        LottoTickets pickedLottoTickets = lottoTickets.pickNumbers();
        List<Rank> rankList = pickedLottoTickets.putRankings(winnerLottoResult);

        // then
        assertThat(rankList).hasSize(14);
    }

    @Test
    @DisplayName("수익률 확인")
    void getYield() {
        // given
        Integer purchasePrice = 1000;
        List<Integer> lottoNumberList = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumberList);
        LottoResult winnerLottoResult = new LottoResult(lottoNumberList);

        // when
        LottoTickets lottoTickets = new LottoTickets(new PurchasePrice(purchasePrice), List.of(lotto));
        List<Rank> rankList = lottoTickets.putRankings(winnerLottoResult);
        BigDecimal yield = lottoTickets.getYield(rankList);

        // then
        assertThat(yield).isEqualTo(BigDecimal.valueOf(5));
    }
}
