package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    private final int size;
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int size) {
        this.size = size;
    }

    public static Lottos purchase(int money) {
        Lottos lottos = new Lottos(money / LOTTO_PRICE);
        lottos.fillAutoRemaining();
        return lottos;
    }

    public void fillAutoRemaining() {
        int remain = size - lottos.size();
        for (int i = 0; i < remain; i++) {
            lottos.add(LottoGenerator.shuffleAndGet());
        }
    }

    public int size() {
        return lottos.size();
    }
}
