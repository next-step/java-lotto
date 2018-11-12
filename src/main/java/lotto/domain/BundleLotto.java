package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class BundleLotto {
    private List<Lotto> lottos;

    public BundleLotto() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
