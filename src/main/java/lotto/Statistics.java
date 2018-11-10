package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * 통계
 */
public class Statistics {
    private static final Map<Integer, Integer> prices;
    private Map<Integer, Long> results;

    static {
        prices = new HashMap<>();
        prices.put(3, 5000);
        prices.put(4, 50000);
        prices.put(5, 1500000);
        prices.put(6, 2000000000);
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
        int sum = 0;
        for (int i = 3; i <=6 ; i++) {
            sum += prices.get(i) * getMatchGroupNum(i);
        }
        double profitRate = (double) sum / moneyAmount;
        if(Double.isNaN(profitRate)) {
            return 0;
        }
        return profitRate;
    }

    public Map<Integer, Long> getResults() {
        return results;
    }
}
