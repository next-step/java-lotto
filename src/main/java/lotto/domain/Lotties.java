package lotto.domain;

import java.util.*;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        this.lotties = new ArrayList<>(lotties);
    }

    public int size() {
        return lotties.size();
    }

    public void matchLottiesRank(WinningNumbers winningNumber) {
        for (Lotto lotto : lotties) {
            lotto.matchLottoRank(winningNumber);
        }
    }

    public List<Lotto> getLotties() {
        return Collections.unmodifiableList(lotties);
    }

    public WinningStatistics getLottiesRank() {
        Map<Rank, Integer> rankMap = new HashMap<>();
        for (Lotto lotto : lotties) {
            rankMap.put(lotto.getRank(), rankMap.getOrDefault(lotto.getRank(), 0) + 1);
        }
        return new WinningStatistics(rankMap);
    }
}
