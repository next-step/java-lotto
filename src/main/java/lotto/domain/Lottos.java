package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public List<Integer> match(WinningLotto winningLotto) {
        List<Integer> matchCounts = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchCounts.add(lotto.match(winningLotto.getNumbers()));
        }

        return matchCounts;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
