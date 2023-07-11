package lotto;

import java.util.ArrayList;
import java.util.List;

public final class Lottos {

    public static final int LOTTO_PRICE = 1_000;

    private final List<Lotto> lottos;

    public Lottos(final int price, final NumbersGenerator numberGenerator) {
        this.lottos = new ArrayList<>();
        for (int count = 0; count < price / LOTTO_PRICE; count++) {
            this.lottos.add(new Lotto(numberGenerator.generate()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
