package step2.domain.price;

import step2.domain.lotto.NormalLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PriceList {
    List<Price> prices;

    public PriceList(List<Integer> matchCount, List<Boolean> bonusMatch) {
        this.prices = IntStream.range(0, matchCount.size())
                .mapToObj(idx -> Price.price(matchCount.get(idx), bonusMatch.get(idx)))
                .collect(Collectors.toList());
    }

    public Map<String, Integer> countMap() {
        Map<String, Integer> countMap = initCountMap();
        for (Price price : this.prices) {
            String key = price.getRank();
            Integer value = countMap.get(key);
            countMap.put(key, value + 1);
        }
        return countMap;
    }

    public Map<String, Integer> initCountMap() {
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put(Price.FIFTH.getRank(), 0);
        countMap.put(Price.FORTH.getRank(), 0);
        countMap.put(Price.THIRD.getRank(), 0);
        countMap.put(Price.SECOND.getRank(), 0);
        countMap.put(Price.FIRST.getRank(), 0);
        return countMap;
    }

    public double getProfitIndex() {
        double profit = 0;
        for (Price price : this.prices) {
            profit += price.getPrize();
        }
        profit /= NormalLotto.PRICE;
        return profit;
    }

    public Map<String, Integer> priceMap() {
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put(Price.FIFTH.getRank(), Price.FIFTH.getPrize());
        countMap.put(Price.FORTH.getRank(), Price.FORTH.getPrize());
        countMap.put(Price.THIRD.getRank(), Price.THIRD.getPrize());
        countMap.put(Price.SECOND.getRank(), Price.SECOND.getPrize());
        countMap.put(Price.FIRST.getRank(), Price.FIRST.getPrize());
        return countMap;
    }

}
