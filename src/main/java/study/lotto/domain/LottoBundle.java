package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    private List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
