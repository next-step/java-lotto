package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    private List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> lottoBundle(int count, Shuffle suffle) {

        for (int idx = 0; idx < count; idx++) {
            lottos.add(LottoGenerator.lottoGenerator(suffle));
        }

        return lottos;
    }
}
