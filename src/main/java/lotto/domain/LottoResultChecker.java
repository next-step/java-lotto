package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LottoResultChecker {
    Map<LottoRank, Integer> countByRank = new HashMap<>();

    public LottoResultChecker(LottoTicket[] lottoTickets, ArrayList<Integer> winningNumbers) {
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.getMatchCount(winningNumbers);
            LottoRank lottoRank = LottoRank.findByMatchedCount(matchCount);

            countByRank.compute(lottoRank, (key, value) -> value == null ? 1 : value + 1);
        }
    }

    public int getRankCount(LottoRank rank) {
        return countByRank.get(rank);
    }

    public int getTotalPrizeMoney() {
        return countByRank.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }
}
