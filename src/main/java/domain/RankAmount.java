package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankAmount {

    private Map<Rank, Long> rankAmount;

    private RankAmount(List<Lotto> attempts) {
        rankAmount = countRankAmount(attempts);
    }

    public static RankAmount from(List<Lotto> attempts) {
        return new RankAmount(attempts);
    }

    public Map<Rank, Long> getRankAmount() {
        return rankAmount;
    }

    public Map<Rank, Long> countRankAmount(List<Lotto> attempts) {
        return attempts.stream()
                .collect(Collectors.groupingBy(Lotto::getRank, Collectors.counting()));
    }

    public Long inquireAmount(Rank rank) {
        return rankAmount.get(rank) != null? rankAmount.get(rank) : 0L;
    }

    public float calculateYield(Money purchaseAmount) {
        return (float) calculateTotalSum()/purchaseAmount.getMoney();
    }

    private Long calculateTotalSum() {
        Long money = 0L;
        for (Rank rank : rankAmount.keySet()) {
            money += rank.calculateRankSum(inquireAmount(rank));
        }
        return money;
    }



}
