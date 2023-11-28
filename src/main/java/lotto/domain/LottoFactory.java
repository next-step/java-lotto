package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoFactory {
    private List<LottoTicket> tickets = new ArrayList<>();
    private int MAX_COUNT = 6;
    private Random random;

    public LottoFactory(int numberOfTickets, List<String []> manualLottoTickets) {
        random = new Random();
        for (int i = 0; i < numberOfTickets; i++) {
            LottoTicket ticket = new LottoTicket(generateTicket());
            tickets.add(ticket);
        }
        generateManualTickets(manualLottoTickets);
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

    public List<Integer> generateTicket() {
        List<Integer> ticket = new ArrayList<>();
        while (ticket.size() < MAX_COUNT) {
            int randomNumber = random.nextInt(45) + 1;
            addNumber(randomNumber, ticket);
        }
        return ticket;
    }

    private void generateManualTickets(List<String[]> manualLottoTickets) {
        for (int i = 0; i < manualLottoTickets.size(); i++) {
            List<Integer> inputInList = Arrays.stream(manualLottoTickets.get(i))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            LottoTicket manualTicket = new LottoTicket(inputInList);
            this.tickets.add(manualTicket);
        }
    }

    public LottoTicket selectTicket(int n) {
        return tickets.get(n);
    }
}
