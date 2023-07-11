package lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoManager {

    private final List<Lotto> lottos;

    public LottoManager(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoRank, Integer> getResult(WinningLotto winningLotto) {
        return null;
    }
}
