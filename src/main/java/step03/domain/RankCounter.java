package step03.domain;

import step03.Rank;
import utils.DoubleParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RankCounter {
    Map<Rank, Integer> rankCounter;

    private RankCounter() {
        Map<Rank, Integer> temp = new HashMap<>();
        Rank.stream().forEach(rank -> temp.put(rank, 0));
        rankCounter = temp;
    }

    public static RankCounter of() {
        return new RankCounter();
    }

    public Integer getCount(Rank key) {
        return rankCounter.get(key);
    }

    public void put(Rank key, Integer value) {
        rankCounter.put(key, value);
    }

    public void increase(Rank key) {
        rankCounter.put(key, rankCounter.getOrDefault(key, 0) + 1);
    }

    public Integer calculateRewardAll() {
        int sum = 0;
        for(Map.Entry<Rank, Integer> elem : rankCounter.entrySet() ){
            sum += elem.getKey().getWinningMoney() * elem.getValue();
        }
        return sum;
    }

    public Integer getTotalCount() {
        int sum = 0;
        for(Map.Entry<Rank, Integer> elem : rankCounter.entrySet() ){
            sum += elem.getValue();
        }
        return sum;
    }

    public double calculateGainRate() {
        double spent = LottoSeller.PRICE_OF_LOTTO * getTotalCount();
        double reward = calculateRewardAll();
        return DoubleParser.getTwoDecimalPoint(reward / spent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankCounter that = (RankCounter) o;
        return Objects.equals(rankCounter, that.rankCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankCounter);
    }

}
