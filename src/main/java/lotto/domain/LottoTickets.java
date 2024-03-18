package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public Map<Integer, Integer> getLottoStatistics(List<Integer> winNumbers) {
        Map<Integer, Integer> statisticMap = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            int hit = lottoTicket.matchNumbers(winNumbers);
            addStatistic(statisticMap, hit);
        }

        return statisticMap;
    }

    private void addStatistic(Map<Integer, Integer> statisticMap, int hit) {
        statisticMap.put(hit, statisticMap.getOrDefault(hit, 0) + 1);
    }

    public List<LottoTicket> get() {
        return this.lottoTickets;
    }

    public int size() {
        return this.lottoTickets.size();
    }
}
