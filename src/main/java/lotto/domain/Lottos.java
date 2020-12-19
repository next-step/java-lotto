package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final int size;
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int size) {
        this.size = size;
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
