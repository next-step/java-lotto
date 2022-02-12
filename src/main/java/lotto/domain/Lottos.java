package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Lottos add(Lottos lottos) {
        List<Lotto> defensiveCopyingLottos = new ArrayList<>(this.lottos);
        defensiveCopyingLottos.addAll(lottos.lottos);
        return new Lottos(defensiveCopyingLottos);
    }
}
