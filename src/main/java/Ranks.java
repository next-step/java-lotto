import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ranks {

    private final Map<Rank, Integer> map;

    public Ranks(List<Rank> ranks) {
        map = new HashMap<>();
        for (Rank rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
    }

    public int count(Rank rank) {
        return map.getOrDefault(rank, 0);
    }

    public int totalPrizeMoney() {
        int totalPrizeMoney = 0;
        for (Rank rank : map.keySet()) {
            totalPrizeMoney += rank.prizeMoney(map.get(rank));
        }
        return totalPrizeMoney;
    }
}
