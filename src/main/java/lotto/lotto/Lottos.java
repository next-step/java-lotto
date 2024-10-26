package lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> createLotto) {
        lottos.addAll(createLotto);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int getSize() {
        return lottos.size();
    }

    public Lotto get(int idx) {
        return lottos.get(idx);
    }

}
