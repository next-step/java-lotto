package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBox {

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoBox(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<WinningResult> retrieveCorrectNum(Lotto winningLotto, LottoBall bonusBall) {
        List<WinningResult> winningResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int correctCount = lotto.retrieveCorrectLottoBallCount(winningLotto);
            boolean bonusMatch = lotto.matchBounsBall(bonusBall);
            winningResults.add(new WinningResult(correctCount, bonusMatch));
        }

        return winningResults;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
