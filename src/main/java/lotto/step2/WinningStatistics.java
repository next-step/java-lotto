package lotto.step2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningStatistics {

    private Map<Rank, Integer> winningStatistics = new HashMap<>();
    private Money money;

    public WinningStatistics(Money money) {
        Arrays.stream(Rank.values())
                .forEach(rank -> winningStatistics.put(rank, 0));
        this.money = money;
    }

    public Map<Rank, Integer> statistics() {
        return winningStatistics;
    }

    public void hit(long hit) {
        Rank rank = Rank.from(hit);
        winningStatistics.put(rank, winningStatistics.get(rank) + 1);
    }

    public long sum() {
        long sum = 0;
        for(Rank rank : winningStatistics.keySet()) {
            long multiple = rank.amount() * winningStatistics.get(rank);
            sum += multiple;
        }
        return sum;
    }

    public BigDecimal profits() {
        return money.profits(sum());
    }

}
