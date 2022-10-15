package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBox {

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoBox(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<WinningResult> retrieveCorrectNum(WinningLotto winnerLotto) {
        List<WinningResult> winningResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            WinningResult winningResult = winnerLotto.retrieveWinnerResult(lotto);
            winningResults.add(winningResult);
        }

        return winningResults;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
