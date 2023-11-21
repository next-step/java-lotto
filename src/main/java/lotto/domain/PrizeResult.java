package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class PrizeResult {
    private final Map<MatchInfo, Integer> prizeResultInfoList = new HashMap<>();

    public PrizeResult(){
        for(MatchInfo matchInfo : MatchInfo.values()){
            prizeResultInfoList.put(matchInfo, 0);
        }
    }

    public void addPrizeResult(MatchInfo matchInfo){
        prizeResultInfoList.put(matchInfo, prizeResultInfoList.get(matchInfo)+1);
    }

    public Map<MatchInfo, Integer> getPrizeResultInfoList(){
        return prizeResultInfoList;
    }

    public double getEarnRate(int inputMoney){
        int income = prizeResultInfoList.entrySet()
                .stream()
                .mapToInt(matchInfoIntegerEntry -> matchInfoIntegerEntry.getKey().getReward() * matchInfoIntegerEntry.getValue())
                .sum();
        return (double) income/inputMoney;
    }
}
