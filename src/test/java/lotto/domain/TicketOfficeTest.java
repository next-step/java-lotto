package lotto.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketOfficeTest {

    @DisplayName("자동 구입전략으로 로또 티켓을 구입")
    @Test
    void issueLottoTicketByAutoPurchaseStrategy() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(14_000);

        // when
        List<LottoTicket> lottoTickets = LottoTicketOffice.issue(new AutoPurchase(), purchaseAmount);

        // then
        assertThat(lottoTickets).hasSize(14);
    }

    @Disabled("2단계에서 구현 예정")
    @DisplayName("수동 구입전략으로 로또 티켓을 구입")
    @Test
    void issueLottoTicketByManualPurchaseStrategy() {
        // given

        // when

        // then
    }
}
