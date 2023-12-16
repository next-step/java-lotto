package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchResult {

    private Map<Rank, Integer> matchResult;

    public MatchResult(){
        matchResult = new HashMap<>(){{
            put(Rank.FIRST, 0);
            put(Rank.SECOND, 0);
            put(Rank.THIRD, 0);
            put(Rank.FOURTH, 0);
            put(Rank.FIFTH, 0);
            put(Rank.MISS, 0);
        }};
    }

    public MatchResult(Map<Rank, Integer> matchResult){
        this.matchResult = matchResult;
    }

    void addMatchResult(Lotto lotto, WinningLotto winningLotto) {
        Rank rank = winningLotto.matchRank(lotto);
        matchResult.put(rank, matchResult.get(rank) + 1);
    }

    public int matchCountOf(Rank rank) {
        return matchResult.get(rank);
    }

    public double calculateReturnRate(int payMoney) {
        return Math.floor((double)Rank.calculateTotalWinningMoney(this) / payMoney * 100) / 100;
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "matchResult=" + matchResult +
                '}';
    }
}
