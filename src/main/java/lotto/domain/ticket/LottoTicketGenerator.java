package lotto.domain.ticket;

import lotto.domain.PurchaseAmount;

public interface LottoTicketGenerator {
    LottoTickets generate(PurchaseAmount purchaseAmount);
}
