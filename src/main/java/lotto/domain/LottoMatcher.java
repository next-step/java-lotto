package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatcher {

    public static Map<Rank, Integer> match(WinnerNumbers winnerNumbers, List<Lotto> lottoList) {
        Map<Rank, Integer> winningStats = new HashMap<>();
        lottoList.forEach(lotto -> markWinning(winningStats, winnerNumbers, lotto));
        return winningStats;
    }

    private static void markWinning(Map<Rank, Integer> winningStats, WinnerNumbers winnerNumbers, Lotto lotto) {
        int matchCount = winnerNumbers.matchCount(lotto);
        if (3 <= matchCount) {
            markRank(winningStats, matchCount);
        }
    }

    private static void markRank(Map<Rank, Integer> winningStats, int matchCount) {
        Rank rank = Rank.findByMatchCount(matchCount);
        Integer lastCountOfRank = winningStats.getOrDefault(rank, 0);
        winningStats.put(rank, lastCountOfRank + 1);
    }
}
