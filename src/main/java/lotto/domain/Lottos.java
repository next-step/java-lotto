package lotto.domain;

import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(Lottos lottos1, Lottos lottos2) {
        List<Lotto> result = new ArrayList<>();
        result.addAll(lottos1.lottos);
        result.addAll(lottos2.lottos);
        return new Lottos(result);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getSize() {
        return lottos.size();
    }

    public Ranks getRanks(WinnerLotto winnerLotto) {
        List<Rank> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(winnerLotto.match(lotto));
        }
        return new Ranks(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
