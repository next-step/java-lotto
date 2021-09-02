package lotto.game;

import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        this.tickets = new LottoTickets(payments.ticketCount(), convert(manualLottoTickets));
    }

    private List<List<Integer>> convert(int[][] numbers) {
        return Arrays.stream(numbers)
                .map(x -> Arrays.stream(x).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> lottoTickets() {
        return this.tickets.value();
    }

    public Payments payments() {
        return this.payments;
    }

    public int manualTicketCount() {
        return tickets.manualTicketCount();
    }

    public int autoTicketCount() {
        return tickets.autoTicketCount();
    }
}
