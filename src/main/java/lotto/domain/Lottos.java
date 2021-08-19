package lotto.domain;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public List<Rank> compareLottos(WinningLotto winningLotto) {
        List<Rank> matchesCount = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchesCount.add(winningLotto.compareLotto(lotto));
        }
        return matchesCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
