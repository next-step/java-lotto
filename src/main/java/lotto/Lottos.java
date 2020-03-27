package lotto;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public int findCountOfThreeNumMatching(List<Integer> winningLotto) {
        return 0;
    }
}
