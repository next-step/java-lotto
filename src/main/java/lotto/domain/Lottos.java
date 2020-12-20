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

    public Lottos generateAutoLottos(int buyCnt) {
        for (int i = 0; i < buyCnt; i++) {
            Lotto lotto = new Lotto(AutoLottoNumberPool.getLottoNumbers());
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public Lottos generateManualLottos(List<Lotto> manualLottos) {
        return new Lottos(manualLottos);
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lottos conbine(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
        return new Lottos(this.lottos);
    }
}
