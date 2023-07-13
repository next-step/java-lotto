package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PurChasedLotto {

    private final List<Lotto> lottos;

    public PurChasedLotto(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
