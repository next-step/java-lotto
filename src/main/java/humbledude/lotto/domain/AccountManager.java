package humbledude.lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class AccountManager {

    private final List<LottoTicket> tickets = new ArrayList<>();
    private final Map<LottoPrize, List<LottoTicket>> resultMap = new HashMap<>();

    public void addTickets(List<LottoTicket> tickets) {
        this.tickets.addAll(tickets);
    }

    public void claimPrize(LottoStore store) {
        resultMap.putAll(tickets.stream()
                .collect(Collectors.groupingBy(store::claimPrize)));
    }

    public double getProfitRate() {
        return (double) getTotalPrize() / (double) getTotalSpent();
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public Map<LottoPrize, List<LottoTicket>> getResultMap() {
        return resultMap;
    }

    private long getTotalPrize() {
        AtomicLong totalPrize = new AtomicLong(0L);
        resultMap.forEach((prize, tickets) -> totalPrize.addAndGet(prize.getPrize() * tickets.size()));

        return totalPrize.get();
    }

    private long getTotalSpent() {
        return tickets.size() * LottoStore.LOTTO_TICKET_PRICE;
    }

}
