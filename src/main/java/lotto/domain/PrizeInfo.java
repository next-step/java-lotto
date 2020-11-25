package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PrizeInfo {
    private final Map<Rank, Prize> prizeMap = new HashMap<>();
    private BiFunction<Pick, LottoBalls, Rank> rankChecker;

    public Map<Rank, Prize> getPrizeMap() {
        return prizeMap;
    }

    public void setPrizeChecker(BiFunction<Pick, LottoBalls, Rank> rankChecker) {
        this.rankChecker = rankChecker;
    }

    public Rank checkRank(Pick pick, LottoBalls winningBalls) {
        return this.rankChecker.apply(pick, winningBalls);
    }

    public void add(Rank rank, Cash cash, String ruleDescription) {
        prizeMap.putIfAbsent(rank, new Prize(rank, cash, ruleDescription));
    }

}
