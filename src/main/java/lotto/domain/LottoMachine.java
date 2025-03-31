package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoConstant.*;

public class LottoMachine {
    private final PurchaseAmount amount;
    private final LottoTickets tickets;

    public LottoMachine(int amount) {
        this.amount = new PurchaseAmount(amount);
        this.tickets = new LottoTickets(issueTickets(this.amount.getTicketCount()));
    }

    public LottoMachine(int amount, List<List<Integer>> ticketNumbers) {
        this.amount = new PurchaseAmount(amount, ticketNumbers.size());
        int autoCount = this.amount.getTicketCount() - ticketNumbers.size();
        this.tickets = new LottoTickets(issueTickets(autoCount), getManualTickets(ticketNumbers));
    }

    private static List<LottoTicket> getManualTickets(List<List<Integer>> ticketNumbers) {
        return ticketNumbers.stream()
                .map(ticketNumbersList -> new LottoTicket(false, ticketNumbersList))
                .collect(Collectors.toList());
    }

    private List<LottoTicket> issueTickets(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new LottoTicket(generateTicketNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> generateTicketNumbers() {
        List<Integer> candidates = IntStream.rangeClosed(TICKET_NUMBER_MIN, TICKET_NUMBER_MAX)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(candidates);

        return candidates.subList(0, TICKET_NUMBER_SIZE);
    }

    public LottoTickets getTickets() {
        return tickets;
    }

    public int getTicketCount() {
        return tickets.getCount();
    }

    public Map<LottoRank, Integer> getRankStatistics(WinningLotto winningLotto) {
        return tickets.getRankStatistics(winningLotto);
    }

    public double getReturnRate(WinningLotto winningLotto) {
        return amount.getReturnRate(tickets.income(winningLotto));
    }

}
