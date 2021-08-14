package lotto.ticketingway;

import java.util.List;
import lotto.domain.LottoPurchaseOrder;
import lotto.domain.LottoTicket;
import lotto.domain.TicketCount;

public interface LottoTicketingWay {

    List<LottoTicket> issueLottoTickets(TicketCount lottoTicketCount, LottoPurchaseOrder order);
}
