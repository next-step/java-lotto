package lotto.model;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * 통계
 */
public class Statistics {
    private Map<Integer, Long> results;

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
        return Arrays.stream(PrizeMoneyType.values())
                .mapToInt(p-> p.getPrizeMoney() * getMatchGroupNum(p.getMatchNum()))
                .sum();
    }

    public Map<Integer, Long> getResults() {
        return results;
    }
}
