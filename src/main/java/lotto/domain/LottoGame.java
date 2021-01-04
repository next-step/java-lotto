package lotto.domain;

import java.util.List;

public class LottoGame {
    private Lottos lottos;
    private LottoResult lottoResult;

    public LottoGame() {
        this.lottos = new Lottos();
    }


    public void start(LottoCount lottoCount) {
        LottoNumberRepository lottoNumberRepository = new LottoNumberRepository();
        for (int i = 0; i < lottoCount.count(); i++) {
            Lotto lotto = new Lotto(lottoNumberRepository.getAutoLottoNumbers());
            lottos.add(lotto);
        }

        lottoResult = new LottoResult(lottos, lottoCount);
        lottoResult.reportLottos();
    }

    public List<MatchResult> match(WinningLotto winningLotto) {
        return lottos.match(winningLotto);
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
}
