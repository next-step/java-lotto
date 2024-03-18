package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static lotto.domain.LottoInformation.*;

public class LottoStatistics {

    private final Map<Integer,  Integer> statisticsMap;

    public LottoStatistics(LottoTickets lottoTickets, List<Integer> winNumbers) {
        this.statisticsMap = new HashMap<>();
        setInitValue();
        setStatistics(lottoTickets, winNumbers);
    }

    private void setInitValue() {
        for (int matchCount = NUMBER_INDEX_FROM; matchCount <= NUMBER_INDEX_TO; matchCount++) {
            this.statisticsMap.put(matchCount, 0);
        }
    }

    private void setStatistics(LottoTickets tickets, List<Integer> winNumbers) {
        for (LottoTicket lottoTicket : tickets.get()) {
            int matchCount = lottoTicket.matchNumbers(winNumbers);
            addStatistic(matchCount);
        }
    }

    private void addStatistic(int matchCount) {
        if (LottoInformation.isExistMatchCount(matchCount)) {
            this.statisticsMap.put(matchCount, this.statisticsMap.get(matchCount) + 1);
        }
    }

    public Set<Integer> keySet() {
        return this.statisticsMap.keySet();
    }

    public int getMatchedLottoCount(int matchCount) {
        return this.statisticsMap.get(matchCount);
    }
}
