import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankCount {
    private  Map<Rank, Integer> rankCount = new HashMap<>();

    public RankCount() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rankCount.put(rank, 0));
    }

    public void countPlusOne(Rank rank) {
        int previousCount = rankCount.get(rank);
        rankCount.put(rank, previousCount + 1);
    }

    public double getWinningMoney() {
        double sum = 0;
        for (Rank rank : rankCount.keySet()) {
            sum += rank.getWinningMoney() * rankCount.get(rank);
        }

        return sum;
    }

    public int getRankCount(Rank rank) {
        return rankCount.get(rank);
    }
}
