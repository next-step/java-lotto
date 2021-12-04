package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;

    }

    public static Lottos buy(Money money) {

        List<Lotto> lottos = new ArrayList<>();
        int countCanBuy = money.countCanBuy(LOTTO_PRICE);

        for(int i = 0; i < countCanBuy; i++) {
            lottos.add(new Lotto());
        }

        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int count() {
        return lottos.size();
    }
}
