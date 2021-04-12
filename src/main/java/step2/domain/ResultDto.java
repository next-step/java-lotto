package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class ResultDto {
    private int sumOfPrizeMoney = 0;
    private Map<Integer, Integer> matchCountMap = new HashMap<>();
    private double earningRatio;

    public void setMatchCount(Map<Integer, Integer> matchCountMap){
        this.matchCountMap = matchCountMap;
    }

    public void setPrizeMoney(int prizeMoneyAsMatchCount){
        sumOfPrizeMoney += prizeMoneyAsMatchCount;
    }

    public Map<Integer, Integer> getMatchCount(){
        return matchCountMap;
    }

    public void setEarningRatio(double earningRatio){
        this.earningRatio = earningRatio;
    }
    public double getEarningRatio(){
        return earningRatio;
    }
}
