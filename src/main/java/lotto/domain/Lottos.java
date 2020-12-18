package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();
    private final NumberPool numberPool = new NumberPool();

    public List<Lotto> generateLottos(int buyCnt) {
        for (int i = 0; i < buyCnt; i++) {
            Lotto lotto = new Lotto(numberPool.getLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }
}
