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
    private Map<Integer, Integer> resultDatas = new HashMap<>();
    private double earningRates;

    public LotteryResult(List<Integer> comparedResults) {
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
            resultDatas.put(rank.matched, 0);
        }
    }
    
    public Integer getRankCount(Integer rankKey) {
        Integer rankCount = resultDatas.get(rankKey);
        return rankCount += 1;
    }

    @ToString
    public enum RANK {
        FOURTH(4, 5_000),
        THIRD(3, 50_000),
        SECOND(2, 1_500_000),
        FIRST(1, 2_000_000_000);

        private Integer matched;
        private Integer price;

        RANK(Integer matched, Integer price) {
            this.matched = matched;
            this.price = price;
        }

        public Integer getMatched() {
            return matched;
        }

        public Integer getPrice() {
            return price;
        }

    }

    private double earningRates(List<Integer> comparedResults) {
        Integer priceMoney = 0;
        for (RANK rank : RANK.values()) {
            priceMoney += rank.getPrice() * getResultDatas().get(rank.getMatched());
        }
        return Math.floor((double) priceMoney / (ONE_GAME_MONEY * comparedResults.size()) * PERCENT_VALUE) / FLOATING_VALUE;
    }
}
