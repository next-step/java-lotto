package lotto.domain;

import java.util.List;

public interface Tickets {
    List<LottoTicket> getLottoTickets();

    String getPurchaseInformation();

    int getPurchaseAmount();

    int getPurchaseCount();
}