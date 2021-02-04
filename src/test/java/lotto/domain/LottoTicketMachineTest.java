package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketMachineTest {

    @DisplayName("자동 구입전략으로 로또 티켓을 구입")
    @Test
    void issueLottoTicketByAutoPurchaseStrategy() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(14_000);

        // when
        PurchaseResult purchaseResult = LottoTicketMachine.issue(new AutoPurchase(), purchaseAmount);
        List<LottoTicket> lottoTickets = purchaseResult.getLottoTickets();

        // then
        assertThat(lottoTickets).hasSize(14);
    }
}
