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

    public Map<Integer, Integer> addMatchResult(List<Lotto> myLottos, List<Integer> winningNumbers) {

        for(Lotto lotto : myLottos){
            int myMatchCount = lotto.matchCount(winningNumbers);
            matchResult.put(myMatchCount, matchResult.get(myMatchCount) + 1);
        }

        return matchResult;
    }

    public double calculateReturnRate(int payMoney) {
        WinningMoney winningMoney = new WinningMoney();

        int total = 0;
        for (int i = MIN_MATCH_COUNT; i < MAX_MATCH_COUNT; i++){
            total += (matchResult.get(i) * winningMoney.winningMoneyOf(i));
        }

        return Math.floor((double)total / payMoney * 100) / 100;
    }
}
