package lotto.domain;

import java.util.List;

public class LottoGame {
    private Lottos lottos;
    private LottoResult lottoResult;

    public LottoGame() {
        this.lottos = new Lottos();
    }


    public void start(LottoCount lottoCount, LottoNumberRepository lottoNumberRepository) {
        addManualLottos(lottoNumberRepository);
        for (int i = 0; i < lottoCount.autoCount(); i++) {
            Lotto lotto = new Lotto(lottoNumberRepository.getAutoLottoNumbers());
            lottos.add(lotto);
        }

        lottoResult = new LottoResult(lottos, lottoCount);
        lottoResult.reportLottos();
    }

    private void addManualLottos(LottoNumberRepository lottoNumberRepository) {
        for (Lotto lotto : lottoNumberRepository.getManualLottos()) {
            lottos.add(lotto);
        }
    }

    public List<MatchResult> match(WinningLotto winningLotto) {
        return lottos.match(winningLotto);
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
}
