package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.Collections;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;

    public LottoGame(int lottoCnt) {
        lottos = createLottos(lottoCnt);
    }

    private List<Lotto> createLottos(int lottoCnt) {
        return LottoGenerator.generateLottos(lottoCnt);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public WinningResult play(WinningLotto winning) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : lottos) {
            int matchCount = winning.match(lotto);
            result.incrementMatchCount(matchCount);
        }
        return result;
    }
}

