package mission.lotto;

import java.util.Map;

public class RankLotto {

    private Map<KLottoRank, Integer> rank;

    public RankLotto(Map<KLottoRank, Integer> rank) {
        this.rank = rank;
    }

    public Map<KLottoRank, Integer> getRank() {
        return rank;
    }
}
