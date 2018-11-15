package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankAmount {

    private Map<Rank, Long> rankAmount;

    public RankAmount(List<Attempt> attempts) {
        rankAmount = countRankAmount(attempts);
    }

    public Map<Rank, Long> getRankAmount() {
        return rankAmount;
    }

    public Map<Rank, Long> countRankAmount(List<Attempt> attempts) {
        return attempts.stream()
                .collect(Collectors.groupingBy(Attempt::getRank, Collectors.counting()));
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
