package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("랭킹 입력 확인")
    void rank() {
        // given
        Integer purchasePrice = 14000;
        LottoNumbers winnerLottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoTickets lottoTickets = new LottoTickets(new PurchasePrice(purchasePrice));
        LottoTickets pickedLottoTickets = lottoTickets.pickNumbers();
        LottoTickets rankedLottoTickets = pickedLottoTickets.putRankings(winnerLottoNumbers);

        // then
        assertThat(rankedLottoTickets.getLottoList().get(0).getRank()).isNotNull();
    }

    @Test
    @DisplayName("랭킹 확인")
    void getRank() {
        // given
        Integer purchasePrice = 14000;
        LottoNumbers winnerLottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoTickets lottoTickets = new LottoTickets(new PurchasePrice(purchasePrice));
        LottoTickets pickedLottoTickets = lottoTickets.pickNumbers();
        LottoTickets rankedLottoTickets = pickedLottoTickets.putRankings(winnerLottoNumbers);
        List<Rank> rankList = rankedLottoTickets.getRank();

        // then
        assertThat(rankList).hasSize(14);
    }

    @Test
    @DisplayName("수익률 확인")
    void getYield() {
        // given
        Integer purchasePrice = 1000;
        Lotto lotto = new Lotto();
        LottoNumbers winnerLottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoTickets lottoTickets = new LottoTickets(new PurchasePrice(purchasePrice), List.of(lotto));
        LottoTickets rankedLottoTickets = lottoTickets.putRankings(winnerLottoNumbers);
        Integer yield = rankedLottoTickets.getYield();

        // then
        assertThat(yield).isEqualTo(5);
    }
}
