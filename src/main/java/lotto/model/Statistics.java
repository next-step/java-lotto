package lotto.model;

import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * 통계
 */
public class Statistics {
    public static final Map<Integer, Integer> PRICES;
    private Map<Integer, Long> results;

    static {
        PRICES = ImmutableMap.<Integer, Integer>builder()
                .put(3, 5000)
                .put(4, 50000)
                .put(5, 1500000)
                .put(6, 2000000000)
                .build();
    }

    public Statistics(List<Ticket> tickets, List<Integer> prizeNums) {
        /*
        일치 갯수별로 그룹핑한 맵
        @Key : 일치 갯수
        @Value : 일치 갯수별 티켓 수
        */
        results = tickets.stream()
                .collect(groupingBy(i -> i.countMatch(prizeNums), counting()));
    }

    /**
     * 일치 갯수그룹 갯수 가져오기
     * @param num
     * @return
     */
    public int getMatchGroupNum(int num) {
         return Optional.ofNullable(results.get(num))
                 .orElse(Long.valueOf(0))
                 .intValue();
    }

    /**
     * 수익률 가져오기
     * @param moneyAmount
     * @return
     */
    public double getProfitRate(int moneyAmount) {
        double profitRate = (double) getProfit() / moneyAmount;
        if(Double.isNaN(profitRate)) {
            return 0;
        }

        return profitRate;
    }

    /**
     * 수익 가져오기
     * @return
     */
    private int getProfit() {
        return PRICES.keySet()
                    .stream()
                    .mapToInt(k->PRICES.get(k) * getMatchGroupNum(k))
                    .sum();
    }

    public Map<Integer, Long> getResults() {
        return results;
    }
}
