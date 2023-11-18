package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int[]... lottosnumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (int[] lottonumbers : lottosnumbers) {
            lottos.add(new Lotto(lottonumbers));
        }
        this.lottos = lottos;
    }

    public List<LottoRank> calculateTotalRank(Lotto winnerLotto) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoRanks.add(LottoRank.evaluateLottoRankByMatchCount(lotto.compareToMatchNumberCount(winnerLotto)));
        }
        return lottoRanks;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    public int getPurchaseLottoSize() {
        return lottos.size();
    }
}
