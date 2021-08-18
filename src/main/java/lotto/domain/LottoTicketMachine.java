package lotto.domain;

import java.util.List;
import lotto.ticketingway.AutoWay;
import lotto.ticketingway.LottoTicketingWay;
import lotto.ticketingway.ManualWay;

public class LottoTicketMachine {

    private final static LottoTicketMachine instance = new LottoTicketMachine();

    private LottoTicketMachine() {
    }

    public static LottoTicketMachine getInstance() {
        return instance;
    }

    private List<LottoTicket> issueTickets(LottoTicketingWay way) {
        return way.issueLottoTickets();
    }

    public AutoLottoTickets issueTicketsByAutoWay(TicketCount autoCount) {
        List<LottoTicket> tickets = issueTickets(new AutoWay(autoCount));
        return new AutoLottoTickets(tickets);
    }

    public ManualLottoTickets issueTicketsByManualWay(int[][] manualLottoNumbers) {
        List<LottoTicket> tickets = issueTickets(new ManualWay(manualLottoNumbers));
        return new ManualLottoTickets(tickets);
    }

}
