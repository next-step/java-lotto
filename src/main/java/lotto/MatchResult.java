package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchResult {
    private static final int MIN_MATCH_COUNT = 3;
    private static final int MAX_MATCH_COUNT = 6;

    private Map<Integer, Integer> matchResult;

    MatchResult(){
        matchResult = new HashMap<>();
        for(int matchCount = MIN_MATCH_COUNT; matchCount <= MAX_MATCH_COUNT; matchCount++){
            matchResult.put(matchCount, 0);
        }
    }

    MatchResult(List<Integer> matchNumberList){
        matchResult = new HashMap<>();
        for(int matchCount = MIN_MATCH_COUNT; matchCount <= MAX_MATCH_COUNT; matchCount++){
            matchResult.put(matchCount, matchNumberList.get(matchCount - MIN_MATCH_COUNT));
        }
    }

    public void addMatchResult(List<Lotto> myLottos, List<Integer> winningNumbers) {

        for(Lotto lotto : myLottos){
            int myMatchCount = lotto.matchCount(winningNumbers);
            if(myMatchCount >= 3){
                matchResult.put(myMatchCount, matchResult.get(myMatchCount) + 1);
            }
        }

    }

    public int matchCountOf(int count){
        return matchResult.get(count);
    }

    public double calculateReturnRate(int payMoney) {
        WinningMoney winningMoney = new WinningMoney();

        int total = 0;
        for (int i = MIN_MATCH_COUNT; i < MAX_MATCH_COUNT; i++){
            total += (matchResult.get(i) * winningMoney.winningMoneyOf(i));
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
