package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public void join(LottoBundle additionalLottoBundle) {
        lottos = new ArrayList<>(lottos);
        lottos.addAll(additionalLottoBundle.lottos);
    }
}
