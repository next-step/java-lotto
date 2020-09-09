package AutoLotto.domain.play;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PlayLottoResult {

    private Map<Rank, Integer> result = new HashMap<>();

    public PlayLottoResult() {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            result.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public void addRank(Rank rank) {
        int count = result.get(rank);
        result.put(rank, count + 1);
    }

    public int getCountByRank(Rank rank) {
        return result.get(rank);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayLottoResult that = (PlayLottoResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}

