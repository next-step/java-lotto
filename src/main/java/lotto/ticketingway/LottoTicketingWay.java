package lotto.ticketingway;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.IssueInput;

public interface LottoTicketingWay {

    List<LottoTicket> issueLottoTickets(IssueInput input);
}
