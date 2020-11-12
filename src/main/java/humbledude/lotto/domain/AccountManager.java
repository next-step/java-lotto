package humbledude.lotto.domain;

import java.util.List;
import java.util.Map;

public class AccountManager {

    private long totalSpent = 0;
    private long totalPrize = 0;

    public void addSpent(long spent) {
        totalSpent += spent;
    }

    public void addPrize(long prize) {
        totalPrize += prize;
    }

    public void addPrize(Map<LottoPrize, List<LottoTicket>> result) {
        result.forEach((prize, tickets) ->
                totalPrize += prize.getPrize() * tickets.size());

    }

    public double getProfitRate() {
        return (double) totalPrize / (double) totalSpent;
    }
}
