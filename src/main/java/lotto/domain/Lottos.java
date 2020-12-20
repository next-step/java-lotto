package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos() {
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos generateLottos(int buyCnt) {
        for (int i = 0; i < buyCnt; i++) {
            Lotto lotto = new Lotto(AutoLottoNumberPool.getLottoNumbers());
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
