package lotto.domain;

import java.util.List;

public interface Tickets {
    List<LottoTicket> getLottoTickets();

    int getPurchaseAmount();

    int getPurchaseCount();
}