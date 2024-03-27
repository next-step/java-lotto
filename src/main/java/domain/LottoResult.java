package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class LottoResult {
    private Map<Integer, Integer> matchedResult;
    private Double profitRate;

    public LottoResult(Map<Integer,Integer> lottoResult, int totalMoney){
        this(findWinningPrizeMap(lottoResult), calculateProfitRate(lottoResult, totalMoney));
    }

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

    private static Map<Integer, Integer> findWinningPrizeMap(Map<Integer, Integer> result) {
        Map<Integer, Integer> prizeMap = new HashMap<>(4);
        IntStream.range(3,7).forEach(count -> prizeMap.put(count, result.getOrDefault(count, 0)));
        return prizeMap;
    }

    private static double calculateProfitRate(Map<Integer, Integer> result, int totalMoney) {
        AtomicInteger totalPrize = new AtomicInteger();
        result.entrySet().stream()
                .filter(e -> e.getKey() >= 3)
                .forEach(entry -> totalPrize.addAndGet(Prize.findPrizeMoneyByCount(entry.getKey()) * entry.getValue()));
        return new BigDecimal(totalPrize.get()).divide(new BigDecimal(totalMoney), 2, RoundingMode.HALF_UP).doubleValue();
    }
}
