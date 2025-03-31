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
        List<Integer> candidates = IntStream.rangeClosed(TICKET_NUMBER_MIN, TICKET_NUMBER_MAX)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(candidates);

        return candidates.subList(0, TICKET_NUMBER_SIZE);
    }

    public List<LottoTicket> getTickets() {
        return tickets.getTickets();
    }

    public Map<LottoRank, Integer> getRankStatistics(LottoTicket winningTicket, LottoNumber bonusBall) {
        return tickets.getRankStatistics(winningTicket, bonusBall);
    }

    public double getReturnRate(LottoTicket winningTicket, LottoNumber bonusBall) {
        return amount.getReturnRate(tickets.income(winningTicket, bonusBall));
    }

}
