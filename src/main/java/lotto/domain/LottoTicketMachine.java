package lotto.domain;

import java.util.List;
import lotto.ticketingway.AutoWay;
import lotto.ticketingway.LottoTicketingWay;
import lotto.ticketingway.ManualWay;

public class LottoTicketMachine {

    private static LottoTicketMachine instance = new LottoTicketMachine();

    private LottoTicketMachine() {
    }

    public static LottoTicketMachine getInstance() {
        return instance;
    }

    public List<LottoTicket> issueTickets(TicketCount count, LottoPurchaseOrder order,
        LottoTicketingWay way) {
        return way.issueLottoTickets(count, order);
    }

    public List<LottoTicket> issueTicketsByAutoWay(TicketCount count, LottoPurchaseOrder order) {
        return issueTickets(count, order, new AutoWay());
    }

    public List<LottoTicket> issueTicketsByManualWay(TicketCount count, LottoPurchaseOrder order) {
        return issueTickets(count, order, new ManualWay());
    }

}
