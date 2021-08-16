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
        LottoDrawResponse lottoDrawResponse = new LottoDrawResponse();
        for (Lotto lotto : lottos) {
            lottoDrawResponse.addOne(winnerLotto.drawLotto(lotto.getNumbers()));
        }
        return lottoDrawResponse;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
