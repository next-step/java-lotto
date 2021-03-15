package step2.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoStatistics {

    public BigDecimal statistics(int paymentMoney, List<Rank> matchResult) {
        BigDecimal totalProfit = BigDecimal.valueOf(totalProfit(matchResult));
        return totalProfit.divide(BigDecimal.valueOf(paymentMoney), 2, RoundingMode.HALF_UP);

    }

    public Map<Integer, List<Rank>> groupMatchOfLotto(List<Rank> matchResult) {
        Map<Integer, List<Rank>> collect = matchResult.stream()
                .collect(Collectors.groupingBy(Rank::getCountOfMatch));
        Rank[] values = Rank.values();
        for (int i = 0; i < Rank.values().length; i++) {
            inputEmptyList(collect, values[i].getCountOfMatch());
        }
        return collect;
    }

    private void inputEmptyList(Map<Integer, List<Rank>> collect, int countOfMatch) {
        if (!collect.containsKey(countOfMatch)) {
            collect.put(countOfMatch, new ArrayList<>());
        }
    }

    public int totalProfit(List<Rank> matchResult) {
        return matchResult.stream()
                .map(Rank::getWinningMoney)
                .reduce(Integer::sum).orElseThrow(() -> new RuntimeException("잘못된 계싼입니다."));
    }
}
