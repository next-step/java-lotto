package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }
}
