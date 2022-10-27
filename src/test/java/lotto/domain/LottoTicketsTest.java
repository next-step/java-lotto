package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    @DisplayName("자동 추첨 수량 확인")
    void pick() {
        // given
        Integer purchasePrice = 14000;

        // when
        LottoTickets lottoTickets = new LottoTickets(new PurchaseInfo(purchasePrice, 0));
        LottoTickets autoPickLottoTickets = lottoTickets.pickNumbers(null);

        // then
        assertThat(autoPickLottoTickets.getLottoList()).hasSize(14);
    }

    @Test
    @DisplayName("랭킹 확인")
    void rank() {
        // given
        Integer purchasePrice = 14000;
        LottoResult winnerLottoResult = new LottoResult(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        LottoTickets lottoTickets = new LottoTickets(new PurchaseInfo(purchasePrice, 0));
        LottoTickets pickedLottoTickets = lottoTickets.pickNumbers(null);
        List<Rank> rankList = pickedLottoTickets.getRanks(winnerLottoResult);

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
        LottoTickets lottoTickets = new LottoTickets(new PurchaseInfo(purchasePrice, 0));
        LottoTickets pickedLottoTickets = lottoTickets.pickNumbers(null);
        List<Rank> rankList = pickedLottoTickets.getRanks(winnerLottoResult);

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
        LottoResult winnerLottoResult = new LottoResult(lottoNumberList, 7);

        // when
        LottoTickets lottoTickets = new LottoTickets(new PurchaseInfo(purchasePrice, 0), List.of(lotto));
        List<Rank> rankList = lottoTickets.getRanks(winnerLottoResult);
        BigDecimal yield = lottoTickets.getYield(rankList);

        // then
        assertThat(yield).isEqualTo(BigDecimal.valueOf(2000000).setScale(2, RoundingMode.HALF_UP));
    }
}
