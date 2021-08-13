package lotto.ticketingway;

import java.util.List;
import lotto.domain.LottoPurchaseOrder;
import lotto.domain.LottoTicket;

public interface LottoTicketingWay {

    List<LottoTicket> issueLottoTickets(int lottoTicketCount, LottoPurchaseOrder order);
}
