package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchResult {

    private Map<Rank, Integer> matchResult;

    public MatchResult(){
        this(List.of(0,0,0,0,0,0,0));
    }

    public MatchResult(List<Integer> matchNumberList){
        matchResult = new HashMap<>();
        for (Rank rank : Rank.values()){
            matchResult.put(rank, matchNumberList.get(rank.getMatchCount()));
        }
    }

    void addMatchResult(List<Lotto> myLottos, WinningLotto winningLotto) {
        for(Lotto lotto : myLottos){
            Rank rank = winningLotto.matchRank(lotto);
            matchResult.put(rank, matchResult.get(rank) + 1);
        }
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
