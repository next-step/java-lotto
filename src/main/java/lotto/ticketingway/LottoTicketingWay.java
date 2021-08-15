package lotto.ticketingway;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine.OrderInput;

public interface LottoTicketingWay {

    List<LottoTicket> issueLottoTickets(OrderInput input);
}
