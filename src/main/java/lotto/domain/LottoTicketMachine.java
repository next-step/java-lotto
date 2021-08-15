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

    private List<LottoTicket> issueTickets(IssueInput input, LottoTicketingWay way) {
        return way.issueLottoTickets(input);
    }

    public AutoLottoTickets issueTicketsByAutoWay(IssueInput input) {
        return new AutoLottoTickets(issueTickets(input, new AutoWay()));
    }

    public ManualLottoTickets issueTicketsByManualWay(IssueInput input) {
        return new ManualLottoTickets(issueTickets(input, new ManualWay()));
    }

}
