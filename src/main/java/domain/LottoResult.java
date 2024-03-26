package domain;

import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> matchedResult;
    private Double profitRate;

    public LottoResult(Map<Integer, Integer> matchedResult, Double profit){
        this.matchedResult = matchedResult;
        this.profitRate = profit;
    }

    public Map<Integer, Integer> getMatchedResult(){
        return this.matchedResult;
    }

    public Double getProfitRate(){
        return this.profitRate;
    }
}
