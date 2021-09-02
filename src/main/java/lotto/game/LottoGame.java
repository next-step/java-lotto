package lotto.game;

import lotto.helper.TypeConverter;
import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;

import java.util.List;

public class LottoGame {
    private final Payments payments;
    private final LottoTickets tickets;

    //TODO: 본 생성자 지워야 하는지 확인 -> 서비스의 유연성을 위해 둬도 되지 않을까
    public LottoGame(int totalPayments) {
        this.payments = new Payments(totalPayments);
        this.tickets = new LottoTickets(payments.ticketCount());
    }

    public LottoGame(int totalPayments, List<List<Integer>> manualLottoTickets) {
        this.payments = new Payments(totalPayments);
        this.tickets = new LottoTickets(payments.ticketCount(), manualLottoTickets);
    }

    public LottoGame(int totalPayments, int[][] manualLottoTickets) {
        this.payments = new Payments(totalPayments);
        this.tickets = new LottoTickets(payments.ticketCount(), TypeConverter.valueOf(manualLottoTickets));
    }

    public List<LottoTicket> lottoTickets() {
        return this.tickets.value();
    }

    public Payments payments() {
        return this.payments;
    }
}
