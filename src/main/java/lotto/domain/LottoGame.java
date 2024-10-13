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

    public WinningResult calculateLottoResult(Lotto winningNumbers) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : lottos) {
            int matchCount = winningNumbers.match(lotto.getLottoNumbers());
            result.incrementMatchCount(matchCount);
        }
        return result;
    }
}
