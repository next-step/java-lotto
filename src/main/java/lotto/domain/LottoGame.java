package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.Collections;
import java.util.List;

public class LottoGame {

    private final List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoGame(int lottoCnt) {
        lottos = createLottos(lottoCnt);
    }

    private List<Lotto> createLottos(int lottoCnt) {
        return LottoGenerator.generateLottos(lottoCnt);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public void addManualLottos(List<Lotto> manualLottos) {
        lottos.addAll(manualLottos);
    }

    public WinningResult play(WinningLotto winning) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : lottos) {
            result.incrementMatchCount(winning.match(lotto));
        }
        return result;
    }
}

