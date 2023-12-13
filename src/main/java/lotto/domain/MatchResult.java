package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchResult {

    private Map<Rank, Integer> matchResult;

    public MatchResult(){
        matchResult = new HashMap<>();
    }

    public MatchResult(Map<Rank, Integer> matchResult){
        this.matchResult = matchResult;
    }

    void addMatchResult(Lotto lotto, WinningLotto winningLotto) {
        Rank rank = winningLotto.matchRank(lotto);
        matchResult.put(rank, matchResultOf(rank) + 1);
    }

    private int matchResultOf(Rank rank) {
        if(matchResult.containsKey(rank)) return matchResult.get(rank);
        return 0;
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
