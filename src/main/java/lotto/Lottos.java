package lotto;

import java.util.ArrayList;
import java.util.List;

public final class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int price, final NumbersGenerator numberGenerator) {
        this.lottos = new ArrayList<>();
        for (int count = 0; count < price / 1_000; count++) {
            this.lottos.add(new Lotto(null));
        }
    }

    public List<Lotto> getList() {
        return lottos;
    }
}
