package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultChecker {
    private Map<LottoRank, Integer> countByRank = new HashMap<>();

    public LottoResultChecker(List<LottoTicket> lottoTickets, LottoTicket winningTicket) {
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.getMatchCount(winningTicket);
            boolean bonusMatched = lottoTicket.isBonusMatched(winningTicket);
            LottoRank lottoRank = LottoRank.findByMatchedCount(matchCount, bonusMatched);

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
