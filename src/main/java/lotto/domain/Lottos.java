package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final int lottoCount;

    public Lottos(int lottoCount) {
        lottos = new ArrayList<>();
        this.lottoCount = lottoCount;
    }

    public void drawLotto() {
        for (int idx = 0; idx < lottoCount; idx++) {
            lottos.add(new Lotto(LottoMachine.raffle()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
