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

    private List<LottoTicket> issueTickets(TicketCount count, LottoPurchaseOrder order,
        LottoTicketingWay way) {
        return way.issueLottoTickets(count, order);
    }

    public AutoLottoTickets issueTicketsByAutoWay(TicketCount count) {
        return new AutoLottoTickets(issueTickets(count, null, new AutoWay()));
    }

    public ManualLottoTickets issueTicketsByManualWay(TicketCount count, LottoPurchaseOrder order) {
        return new ManualLottoTickets(issueTickets(count, order, new ManualWay()));
    }

}
