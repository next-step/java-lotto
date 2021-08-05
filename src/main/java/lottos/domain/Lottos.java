package lottos.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoResult> match(Lotto lotto) {
        return lotto.match(lottos);
    }

    public List<Lotto> elements() {
        return Collections.unmodifiableList(lottos);
    }
}
