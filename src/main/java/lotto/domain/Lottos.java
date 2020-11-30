package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int count) {
        this.lottos = new ArrayList<>();
        purchaseLottos(count);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void purchaseLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }
}
