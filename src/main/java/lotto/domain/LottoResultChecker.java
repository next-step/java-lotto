package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultChecker {
    private Map<LottoRank, Integer> countByRank = new HashMap<>();

    public LottoResultChecker(List<LottoTicket> lottoTickets, WinningNumber winningNumber) {
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = winningNumber.getMatchCount(lottoTicket);
            boolean bonusMatched = winningNumber.isBonusMatched(lottoTicket);
            LottoRank lottoRank = LottoRank.findByMatchedCount(matchCount, bonusMatched);

            countByRank.put(lottoRank, countByRank.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public int getRankCount(LottoRank rank) {
        return countByRank.getOrDefault(rank, 0);
    }

    public long getTotalPrizeMoney() {
        return countByRank.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }
}
