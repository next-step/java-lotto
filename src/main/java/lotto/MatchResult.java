package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchResult {
    private Map<Integer, Integer> matchResult;

    MatchResult(){
        matchResult = new HashMap<>();
        for(int matchCount = 3; matchCount <= 6; matchCount++){
            matchResult.put(matchCount, 0);
        }
    }

    MatchResult(List<Integer> matchNumberList){
        for(int matchCount = 3; matchCount <= 6; matchCount++){
            matchResult.put(matchCount, matchNumberList.get(matchCount-3));
        }
    }

    public Map<Integer, Integer> addMatchResult(List<Lotto> myLottos, List<Integer> winningNumbers) {

        for(Lotto lotto : myLottos){
            int myMatchCount = lotto.matchCount(winningNumbers);
            matchResult.put(myMatchCount, matchResult.get(myMatchCount)+1);
        }

        return matchResult;
    }
}
