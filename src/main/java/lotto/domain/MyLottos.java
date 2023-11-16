package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public MyLottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }


    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult getLottoResult(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        lottos.forEach(lotto -> lottoResult.add(winningLotto.getPrize(lotto)));
        return lottoResult;
    }
}
