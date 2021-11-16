package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos = new ArrayList<>();

    private Lottos(int generateCount) {
        while (lottos.size() < generateCount) {
            this.lottos.add(Lotto.generate());
        }
    }

    public static Lottos purchase(int price) {
        return new Lottos(price / LOTTO_PRICE);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
