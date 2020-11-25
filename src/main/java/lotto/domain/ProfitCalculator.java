package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfitCalculator {

    private final Map<Long, Integer> profitMap;

    public ProfitCalculator() {
        this.profitMap = new HashMap<>();
        profitMap.put(3L, 5000);
        profitMap.put(4L, 50000);
        profitMap.put(5L, 1500000);
        profitMap.put(6L, 2000000000);
    }

    public int calculateProfit(List<LottoTicket> lottoTickets) {
        return lottoTickets.stream().mapToInt(this::calculate).sum();
    }

    public int calculate(LottoTicket lottoTicket) {
        long matchingScore = lottoTicket.getMatchingScore();
        return profitMap.get(matchingScore);
    }
}
