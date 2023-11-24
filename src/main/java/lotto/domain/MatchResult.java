package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchResult {
    private static final int MIN_MATCH_COUNT = 3;
    private static final int MAX_MATCH_COUNT = 6;

    private Map<Integer, Integer> matchResult;

    public MatchResult(){
        matchResult = new HashMap<>();
        for(int matchCount = 0; matchCount <= MAX_MATCH_COUNT; matchCount++){
            matchResult.put(matchCount, 0);
        }
    }

    public MatchResult(List<Integer> matchNumberList){
        matchResult = new HashMap<>();
        for(int matchCount = 0; matchCount <= MAX_MATCH_COUNT; matchCount++){
            matchResult.put(matchCount, matchNumberList.get(matchCount));
        }
    }

    void addMatchResult(List<Lotto> myLottos, WinningLotto winningLotto) {
        int myMatchCount = 0;

        for(Lotto lotto : myLottos){
            myMatchCount = winningLotto.matchCount(lotto);
            matchResult.put(myMatchCount, matchResult.get(myMatchCount) + 1);
        }

    }

    public int matchCountOf(int count){
        return matchResult.get(count);
    }

    double calculateReturnRate(int payMoney) {
        int total = 0;
        for (int i = MIN_MATCH_COUNT; i <= MAX_MATCH_COUNT; i++){
            total += (matchResult.get(i) * Rank.winningMoneyOf(i));
        }

        return Math.floor((double)total / payMoney * 100) / 100;
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "matchResult=" + matchResult +
                '}';
    }
}
