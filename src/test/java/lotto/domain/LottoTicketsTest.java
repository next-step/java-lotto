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
        List<Integer> matchNumberList = List.of(1, 2, 3, 4, 5, 6);

        // when
        LottoTickets lottoTickets = new LottoTickets(new PurchasePrice(purchasePrice));
        LottoTickets pickedLottoTickets = lottoTickets.pickNumbers();
        LottoTickets rankedLottoTickets = pickedLottoTickets.putRankings(matchNumberList);

        // then
        assertThat(rankedLottoTickets.getLottoList().get(0).getRank()).isNotNull();
    }
}
