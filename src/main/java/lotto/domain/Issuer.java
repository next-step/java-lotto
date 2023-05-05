package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Issuer {
    private final Tickets tickets;

    public Issuer() {
        this.tickets = new Tickets(new ArrayList<>());
    }

    public void automaticIssue(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Ticket(issueNumbers()));
        }
    }


    private Set<LottoNumber> issueNumbers() {
        Set<LottoNumber> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(LottoNumber.any());
        }
        return numbers;
    }

    public Tickets issuedTickets() {
        return tickets;
    }

    public Statics issuedTicketStatistics(WinnerTicket winnerTicket) {
        return new Statics(tickets, winnerTicket);
    }


    public void manualIssue(Tickets manualPurchases) {
        tickets.add(manualPurchases);
    }
}
