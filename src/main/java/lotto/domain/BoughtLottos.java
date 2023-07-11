package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BoughtLottos {

    private final int count;
    private final List<Lotto> lottos;

    public BoughtLottos(List<Lotto> lottos) {
        this.count = lottos.size();
        this.lottos = lottos;
    }

    public List<LottoResult> winningResults(final Lotto winningLotto, final Ball bonusBall) {
        return lottos.stream()
                     .map(lotto -> lotto.compareWinningLotto(winningLotto, bonusBall))
                     .collect(Collectors.toList());
    }

    public int getCount() {
        return this.count;
    }
}
