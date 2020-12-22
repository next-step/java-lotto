package lotto.domain;

import java.util.List;

public class LottoGame {
    private Lottos lottos = new Lottos();
    private LottoNumberRepository lottoNumberRepository = new LottoNumberRepository();
    private LottoCount lottoCount;
    private LottoResult lottoResult;

    public LottoGame(LottoCount lottoCount) {
        this.lottoCount = lottoCount;
    }


    public void start() {
        for (int i = 0; i < lottoCount.count(); i++) {
            Lotto lotto = new Lotto(lottoNumberRepository.getAutoLottoNumbers());
            lottos.add(lotto);
        }

        lottoResult = new LottoResult(lottos, lottoCount);
        lottoResult.reportLottos();
    }

    public List<Integer> match(WinningLotto winningLotto) {
        return lottos.match(winningLotto);
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
}
