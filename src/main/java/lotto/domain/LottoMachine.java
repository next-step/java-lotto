package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int TICKET_MAX_NUMBER = 45;
    private static final int TICKET_MIN_NUMBER = 1;
    private static final int TICKET_NUMBER_SIZE = 6;
    private final PurchaseAmount amount;
    private final LottoTickets tickets;

    public LottoMachine(PurchaseAmount amount) {
        this.amount = amount;
        this.tickets = issueTickets(amount.getTicketCount());
    }

    private LottoTickets issueTickets(int count) {
        List<LottoTicket> tickets = IntStream.range(0, count)
                .mapToObj(i -> new LottoTicket(generate()))
                .collect(Collectors.toList());

        return new LottoTickets(tickets);
    }

    private List<Integer> generate() {
        List<Integer> candidates = IntStream.rangeClosed(TICKET_MIN_NUMBER, TICKET_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(candidates);

        return candidates.subList(0, TICKET_NUMBER_SIZE);
    }

    public List<LottoTicket> getTickets() {
        return tickets.getTickets();
    }

    public Map<LottoRank, Integer> getRankStatistics(LottoTicket winningTicket) {
        return tickets.getRankStatistics(winningTicket);
    }

    public double getReturnRate(LottoTicket winningTicket) {
        return amount.getReturnRate(tickets.income(winningTicket));
    }

}
