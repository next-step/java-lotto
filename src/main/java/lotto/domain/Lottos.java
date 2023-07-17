package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(final List<Lotto>... lottoGroups) {
        for (List<Lotto> lottos : lottoGroups) {
            this.lottos.addAll(List.copyOf(lottos));
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
