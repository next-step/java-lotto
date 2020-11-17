package humbledude.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class AccountManager {

    private final List<LottoTicket> tickets = new ArrayList<>();
    private LottoWinningNumbers winningNumbers;

    public void addTickets(List<LottoTicket> tickets) {
        this.tickets.addAll(tickets);
    }

    public void setWinningNumbers(LottoWinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public double getProfitRate() {
        double totalSpent = getTotalSpent();
        double totalPrize = getTotalPrize();

        if (totalSpent == 0) {
            throw new IllegalStateException("돈을 하나도 안썼어요. 돈을 쓰고 수익률을 계산합시다");
        }

        return totalPrize / totalSpent;
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public Map<LottoPrize, List<LottoTicket>> getResultMap() {
        return tickets.stream()
                .collect(Collectors.groupingBy(ticket -> {
                    int matchedCount = winningNumbers.getMatchedCountWith(ticket);
                    return LottoPrize.of(matchedCount);
                }));
    }

    private long getTotalPrize() {
        AtomicLong totalPrize = new AtomicLong(0L);
        getResultMap().forEach((prize, tickets) -> totalPrize.addAndGet(prize.getPrize() * tickets.size()));

        return totalPrize.get();
    }

    private long getTotalSpent() {
        return tickets.size() * LottoStore.LOTTO_TICKET_PRICE;
    }

}
