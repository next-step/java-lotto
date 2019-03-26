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
        FIFTH(3, 5_000, "3개"),
        FOURTH(4, 5_0000, "4개"),
        THIRD(5, 1_500_000, "5개"),
        SECOND(51, 3_000_000, "5개 일치, 보너스 볼"),
        FIRST(6, 2_000_000_000, "6개");

        private int matched;
        private int price;
        private String matchedInfo;

        RANK(int matched, int price, String matchedInfo) {
            this.matched = matched;
            this.price = price;
            this.matchedInfo = matchedInfo;
        }

        public int getMatched() {
            return matched;
        }

        public int getPrice() {
            return price;
        }

        public String getMatchedInfo() {
            return matchedInfo;
        }
    }

    private double earningRates(List<Integer> comparedResults) {
        int priceMoney = 0;
        for (RANK rank : RANK.values()) {
            priceMoney += rank.getPrice() * getResultDatas().get(rank.getMatched());
        }
        return Math.floor((double) priceMoney / (ONE_GAME_MONEY * comparedResults.size()) * PERCENT_VALUE) / FLOATING_VALUE;
    }
}
