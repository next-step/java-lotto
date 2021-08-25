package lotto.domain;

import java.util.List;

public class LottoPaper {

    private final List<Lotto> lottos;

    public LottoPaper(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}

