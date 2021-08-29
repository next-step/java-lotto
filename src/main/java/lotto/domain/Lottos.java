package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Lottos addLottos(List<Lotto> lottos) {
        List<Lotto> result = new ArrayList<>();
        Collections.copy(result, this.lottos);
        result.addAll(lottos);
        return new Lottos(result);
    }

}
