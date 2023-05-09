package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_AMOUNT_OF_MONEY = 1000;
    private final List<Lotto> lottos;

    public Lottos(int amount) {
        this.lottos = generateLottos(amount);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> generateLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount / LOTTO_AMOUNT_OF_MONEY; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public int count() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
