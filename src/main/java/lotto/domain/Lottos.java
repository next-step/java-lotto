package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void storeLotto(final Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Ranking> judgeAllUserLotto(final WinningLotto winningLotto) {
        return lottos.stream()
            .map(winningLotto::matchLotto)
            .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public void storeAllLottos(final List<Lotto> purchasedLottos) {
        lottos.addAll(purchasedLottos);
    }
}
