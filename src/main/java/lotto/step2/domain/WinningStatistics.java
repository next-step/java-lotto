package lotto.step2.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {

    private Map<Rank, Integer> winningStatistics = new HashMap<>();
    private Money money;

    public WinningStatistics(Money money, int fourthRank, int thirdRank, int secondRank, int firstRank) {
        //Test용 생성자
        this(money);
        winningStatistics.put(Rank.from(3),fourthRank);
        winningStatistics.put(Rank.from(4),thirdRank);
        winningStatistics.put(Rank.from(5),secondRank);
        winningStatistics.put(Rank.from(6),firstRank);
    }

    public WinningStatistics(Money money) {
        Arrays.stream(Rank.values())
                .forEach(rank -> winningStatistics.put(rank, 0));
        this.money = money;
    }

    public Map<Rank, Integer> statistics() {
        return Collections.unmodifiableMap(winningStatistics);
    }

    public void hit(long hit) {
        Rank rank = Rank.from(hit);
        winningStatistics.put(rank, winningStatistics.get(rank) + 1);
    }

    private long sum() {
        long sum = 0;
        for(Rank rank : winningStatistics.keySet()) {
            long multiple = rank.amount() * winningStatistics.get(rank);
            sum += multiple;
        }
        return sum;
    }

    public double profits() {
        return money.profits(sum());
    }

}
