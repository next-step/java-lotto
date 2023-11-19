package step2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int[]... lottosnumbers) {
        this(Arrays.stream(lottosnumbers)
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    public List<LottoRank> calculateTotalRank(WinningLotto winnerLotto) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoRanks.add(LottoRank.evaluateLottoRankByMatchCount(winnerLotto.compareToMatchNumberCount(lotto), winnerLotto.checkBonusNumber(lotto)));
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
