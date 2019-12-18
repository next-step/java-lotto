package lotto.domain;

import java.util.List;

class LottoBundle {

    private List<Lotto> lottos;

    private LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    static LottoBundle of(List<Lotto> lottos) {
        return new LottoBundle(lottos);
    }

    int getLottosCount() {
        return lottos.size();
    }
}
