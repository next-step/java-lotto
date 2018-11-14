package Domain;

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

    public Long getAmount(Rank rank) {
        return rankAmount.get(rank) != null? rankAmount.get(rank) : 0L;
    }

    public float calculateYeild(int purchaseAmount) {
        return (float) calculateTotalSum()/purchaseAmount;
    }

    private Long calculateTotalSum() {
        Long money = 0L;
        for (Rank rank : rankAmount.keySet()) {
            money += rank.getRewardMoney() * getAmount(rank);
        }
        return money;
    }

}
