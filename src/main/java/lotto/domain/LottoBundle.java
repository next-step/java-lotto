package lotto.domain;

import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(final List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public int size() {
        return lottoBundle.size();
    }
}
