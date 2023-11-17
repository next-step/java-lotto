package lotto.domain;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public LottoRank matchCount(int lottoCount, LottoWinNumbers lottoWinNumbers, BonusBall bonusBall) {
        return this.lottos.get(lottoCount).matchCount(lottoWinNumbers, bonusBall);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
