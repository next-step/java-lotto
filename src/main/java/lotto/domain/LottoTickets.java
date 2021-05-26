package lotto.domain;

import lotto.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private Money amount;
    private final List<LottoTicket> lottoTickets;
    private final TicketGenerator ticketGenerator;

    public LottoTickets(TicketGenerator ticketGenerator, Money purchaseAmount) {
        this.ticketGenerator = ticketGenerator;
        this.amount = purchaseAmount;
        this.lottoTickets = issueTickets(amount.countOfTickets());
    }

    private List<LottoTicket> issueTickets(int count) {
        List<LottoTicket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            LottoTicket ticket = ticketGenerator.extract();
            ticketList.add(ticket);
        }
        return ticketList;
    }

    public LottoResult matchingResultWith(WinningNumbers winningNumbers) {
        return new LottoResult(winningNumbers, lottoTickets);
    }

    public int count() {
        return lottoTickets.size();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoTicket ticket : lottoTickets) {
            stringBuilder.append(ticket.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
