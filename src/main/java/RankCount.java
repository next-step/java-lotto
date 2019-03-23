import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankCount {
    private static Map<Rank, Integer> rankCount = new HashMap<>();

    static {
        Arrays.stream(Rank.values())
                .forEach(rank -> rankCount.put(rank, 0));
    }

    public static void countPlusOne(Rank rank) {
        int previousCount = rankCount.get(rank);
        rankCount.put(rank, previousCount + 1);
    }

    public static double getWinningMoney() {
        double sum = 0;
        for (Rank rank : rankCount.keySet()) {
            sum += rank.getWinningMoney() * rankCount.get(rank);
        }

        return sum;
    }

    public static int getRankCount(Rank rank) {
        return rankCount.get(rank);
    }
}
