package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoFactory {
    private List<LottoTicket> tickets = new ArrayList<>();
    private int MAX_COUNT = 6;

    public LottoFactory(int numberOfTickets, Random random) {
        for (int i = 0; i < numberOfTickets; i++) {
            LottoTicket ticket = new LottoTicket(generateTicket(random));
            tickets.add(ticket);
        }
    }

    public LottoFactory(LottoTicket lottoTicket) {
        tickets.add(lottoTicket);
    }

    public int numberOfPurchasedTicket () {
        return tickets.size();
    }

    public List<LottoTicket> tickets() {
        return this.tickets;
    }

    private void addNumber(int randomNumber, List<Integer> ticket) {
        if (!ticket.contains(randomNumber)) {
            ticket.add(randomNumber);
        }
    }

    public List<Integer> generateTicket(Random random) {
        List<Integer> ticket = new ArrayList<>();
        while (ticket.size() < MAX_COUNT) {
            int randomNumber = random.nextInt(45) + 1;
            addNumber(randomNumber, ticket);
        }
        Collections.sort(ticket);
        return ticket;
    }

    public LottoTicket selectTicket(int n) {
        return tickets.get(n);
    }
}
