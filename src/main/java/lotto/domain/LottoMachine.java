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
        this.tickets = issueTickets(this.amount.getTicketCount());
    }

    public LottoMachine(int amount, List<LottoTicket> manualTicket) {
        this.amount = new PurchaseAmount(amount, manualTicket.size());
        int autoCount = this.amount.getTicketCount() - manualTicket.size();
        this.tickets = issueTickets(autoCount);
        tickets.addManualTickets(manualTicket);
    }

    private LottoTickets issueTickets(int count) {
        List<LottoTicket> tickets = IntStream.range(0, count)
                .mapToObj(i -> new LottoTicket(generateTicketNumbers()))
                .collect(Collectors.toList());

        return new LottoTickets(tickets);
    }

    private List<Integer> generateTicketNumbers() {
        List<Integer> candidates = IntStream.rangeClosed(TICKET_NUMBER_MIN, TICKET_NUMBER_MAX)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(candidates);

        return candidates.subList(0, TICKET_NUMBER_SIZE);
    }

    public List<LottoTicket> getTickets() {
        return tickets.getTickets();
    }

    public Map<LottoRank, Integer> getRankStatistics(WinningLotto winningLotto) {
        return tickets.getRankStatistics(winningLotto);
    }

    public double getReturnRate(WinningLotto winningLotto) {
        return amount.getReturnRate(tickets.income(winningLotto));
    }

}
