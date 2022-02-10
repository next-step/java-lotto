package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final WinningLotto winningLotto;
    private final Map<Rank, Integer> result;

    public WinningResult(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        this.result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;
            result.put(rank, 0);
        }
    }

    public Map<Rank, Integer> mapResult(List<Lotto> userLottos) {
        for (Lotto lotto : userLottos) {
            Rank rank = getRank(lotto);
            if (rank == Rank.NONE) continue;
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    private Rank getRank(Lotto userLotto) {
        int matchCount = winningLotto.getMatchCount(userLotto);
        boolean matchBonus = winningLotto.getMatchBonus(userLotto);
        return Rank.find(matchCount, matchBonus);
    }

    public double calculateProfitRate(int buyCash) {
        long prizeMoney = calculatePrizeMoney();
        return (double) prizeMoney / buyCash;
    }

    public long calculatePrizeMoney() {
        long prizeMoney = 0;
        for (Rank rank : result.keySet()) {
            prizeMoney += result.get(rank) * rank.getPrizeMoney();
        }
        return prizeMoney;
    }
}
