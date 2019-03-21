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
    private static final Integer INIT_RANK = 0;
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
        FOURTH(3, 5000),
        THIRD(4, 50000),
        SECOND(5, 1500000),
        FIRST(6, 2000000000);

        private Integer matched;
        private Integer price;

        RANK(Integer matched, Integer price) {
            this.matched = matched;
            this.price = price;
        }

        public String getKey() {
            return name();
        }

        public Integer getMatched() {
            return matched;
        }

        public Integer getPrice() {
            return price;
        }

    }
    //TODO : 추후 리팩토링 하겠습니다.
    private double earningRates(List<Integer> comparedResults) {
        Integer earnedMoney = 0;
        for (RANK rank : RANK.values()) {
            earnedMoney += rank.getPrice() * getResultDatas().get(rank.getMatched());
        }
        return Math.floor((double) earnedMoney/(1000 * comparedResults.size())*100)/100.0;
    }
}
