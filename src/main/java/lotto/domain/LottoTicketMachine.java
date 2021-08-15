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

    private List<LottoTicket> issueTickets(OrderInput input, LottoTicketingWay way) {
        return way.issueLottoTickets(input);
    }

    public AutoLottoTickets issueTicketsByAutoWay(OrderInput input) {
        return new AutoLottoTickets(issueTickets(input, new AutoWay()));
    }

    public ManualLottoTickets issueTicketsByManualWay(OrderInput input) {
        return new ManualLottoTickets(issueTickets(input, new ManualWay()));
    }

    public static class OrderInput {

        private final TicketCount autoTicketCount;
        private final int[][] manualLottoNumbers;

        public OrderInput(TicketCount autoTicketCount, int[][] manualLottoNumbers) {
            this.autoTicketCount = autoTicketCount;
            this.manualLottoNumbers = manualLottoNumbers;
        }

        public OrderInput(TicketCount autoTicketCount) {
            this(autoTicketCount, null);
        }

        public OrderInput(int[][] manualLottoNumbers) {
            this(null, manualLottoNumbers);
        }

        public TicketCount getAutoTicketCount() {
            return autoTicketCount;
        }

        public int[][] getManualLottoNumbers() {
            return manualLottoNumbers;
        }
    }

}
