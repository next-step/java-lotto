package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultChecker {
    private Map<LottoRank, Integer> countByRank = new HashMap<>();

    public LottoResultChecker(List<LottoTicket> lottoTickets, List<Integer> winningNumbers) {
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.getMatchCount(winningNumbers);
            LottoRank lottoRank = LottoRank.findByMatchedCount(matchCount);

            countByRank.put(lottoRank, countByRank.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public int getRankCount(LottoRank rank) {
        return countByRank.getOrDefault(rank, 0);
    }

    public int getTotalPrizeMoney() {
        return countByRank.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }
}
