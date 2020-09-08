package AutoLotto.domain.play;

import java.util.HashMap;
import java.util.Map;

public class PlayLottoResult {

    private Map<Rank, Integer> result = new HashMap<>();

    public PlayLottoResult() {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            result.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        int count = result.get(rank);
        result.put(rank, count + 1);
    }

    public int getCountByRank(Rank rank) {
        return result.get(rank);
    }

}

