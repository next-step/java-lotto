package mission.lotto;

import java.util.Map;

public class RankLottos {

    private Map<KLottoRank, Integer> rank;

    public RankLottos(Map<KLottoRank, Integer> rank){
        this.rank = rank;
    }

    public Map<KLottoRank, Integer> getRank() {
        return rank;
    }
}
