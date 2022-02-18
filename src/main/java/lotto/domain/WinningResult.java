package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResult {

    private final Map<Rank, Integer> result;

    private WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public static WinningResult of(Lottos lottos, WinningLotto winningLotto) {
        return new WinningResult(mapResult(lottos, winningLotto));
    }

    public BigDecimal calculateProfitRate(int buyCash) {
        BigDecimal prizeMoney = calculatePrizeMoney();
        return prizeMoney.divide(new BigDecimal(buyCash), 2, RoundingMode.DOWN);
    }

    public BigDecimal calculatePrizeMoney() {
        BigDecimal prizeMoney = BigDecimal.ZERO;
        for (Rank rank : result.keySet()) {
            prizeMoney = prizeMoney.add(new BigDecimal(result.get(rank) * rank.getPrizeMoney()));
        }
        return prizeMoney;
    }

    private static Map<Rank, Integer> mapResult(Lottos lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> result = initResult();

        for (Lotto lotto : lottos.get()) {
            Rank rank = getRank(winningLotto, lotto);
            if (rank == Rank.NONE) continue;
            result.put(rank, result.get(rank) + 1);
        }

        return result;
    }

    private static Map<Rank, Integer> initResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;
            result.put(rank, 0);
        }

        return result;
    }

    private static Rank getRank(WinningLotto winningLotto, Lotto userLotto) {
        int matchCount = winningLotto.getMatchCount(userLotto);
        boolean matchBonus = winningLotto.getMatchBonus(userLotto);
        return Rank.find(matchCount, matchBonus);
    }

    public Map<Rank, Integer> getResult() {
        return new LinkedHashMap<>(result);
    }
}
