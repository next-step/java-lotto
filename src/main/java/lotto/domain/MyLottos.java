package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public MyLottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }


    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public void addManualLottos(MyLottos myLottos) {
        this.lottos.addAll(myLottos.lottos);
    }

    public LottoResult getLottoResult(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        lottos.forEach(lotto -> lottoResult.add(winningLotto.getPrize(lotto)));
        return lottoResult;
    }
}
