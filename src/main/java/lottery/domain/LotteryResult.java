package lottery.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
@EqualsAndHashCode
public class LotteryResult {
    private static final int INIT_RANK = 0;
    private static final int ONE_GAME_MONEY = 1000;
    public static final int PERCENT_VALUE = 100;
    public static final double FLOATING_VALUE = 100.0;
    private Map<RANK, Integer> resultDatas = new HashMap<>();
    private double earningRates;

    public LotteryResult(List<RANK> comparedResults) {
        initResultDatas();
        comparedResults.forEach(comparedResult -> {
            if(resultDatas.containsKey(comparedResult)) {
                resultDatas.put(comparedResult, getRankCount(comparedResult));
            }
        });
        this.earningRates = earningRates(comparedResults);
    }

    public double getEarningRates() {
        return earningRates;
    }

    private void initResultDatas() {
        for (RANK rank : RANK.values()) {
            resultDatas.put(rank, 0);
        }
    }
    
    public int getRankCount(RANK rankKey) {
        int rankCount = resultDatas.get(rankKey);
        return rankCount += 1;
    }

    private double earningRates(List<RANK> comparedResults) {
        int priceMoney = 0;
        for (RANK rank : RANK.values()) {
            priceMoney += rank.getPrice() * getResultDatas().get(rank);
        }
        return Math.floor((double) priceMoney / (ONE_GAME_MONEY * comparedResults.size()) * PERCENT_VALUE) / FLOATING_VALUE;
    }
}
