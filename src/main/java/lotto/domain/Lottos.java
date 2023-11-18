package lotto.domain;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<LottoRank> matchCount(LottoWin lottoWin) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (Lotto lotto : this.lottos) {
            LottoRank lottoRank = lotto.matchCount(lottoWin);
            lottoRanks.add(lottoRank);
        }
        return lottoRanks;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
