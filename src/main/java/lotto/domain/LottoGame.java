package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoGame {

    private final List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public WinningResult play(WinningLotto winning) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : lottos) {
            result.incrementMatchCount(winning.match(lotto));
        }
        return result;
    }
}

