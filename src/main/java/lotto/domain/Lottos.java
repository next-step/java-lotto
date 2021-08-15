package lotto.domain;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public LottoDrawResponse drawLottos(WinnerLotto winnerLotto) {
        LottoDrawResponse lottoResult = new LottoDrawResponse();
        for (Lotto lotto : lottos) {
            lottoResult.addOne(lotto.drawLotto(winnerLotto));
        }
        return lottoResult;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
