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
        int myMatchCount = 0;

        for(Lotto lotto : myLottos){
            myMatchCount = winningLotto.matchCount(lotto);
            matchResult.put(Rank.returnRank(myMatchCount), matchResult.get(Rank.returnRank(myMatchCount)) + 1);
        }

    }

    public int matchCountOf(Rank rank) {
        return matchResult.get(rank);
    }

    double calculateReturnRate(int payMoney) {
        return Math.floor((double)Rank.calculateTotalWinningMoney(this) / payMoney * 100) / 100;
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "matchResult=" + matchResult +
                '}';
    }
}
