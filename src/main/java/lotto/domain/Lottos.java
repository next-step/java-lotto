package lotto.domain;

import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Rank> getRanks(WinnerLotto winnerLotto) {
        List<Rank> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(winnerLotto.match(lotto));
        }
        return result;
    }
}
