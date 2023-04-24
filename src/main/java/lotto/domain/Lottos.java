package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static final int LOTTO_AMOUNT = 1_000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        int count = amount / LOTTO_AMOUNT;
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.purchase());
        }
        return new Lottos(lottos);
    }

    public int count() {
        return lottos.size();
    }

    public List<Lotto> lottos() {
        return new ArrayList<>(lottos);
    }

}
