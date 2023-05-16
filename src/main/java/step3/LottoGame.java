package step3;

import step3.domain.Lottos;
import step3.domain.LottosTotalResult;

import java.util.List;

public class LottoGame {
    private final Lottos lottos;

    public LottoGame(int purchaseAmount) {
        this.lottos = new Lottos(purchaseAmount);
    }

    public LottosTotalResult getTotalResult(List<Integer> winningNumbers, int bonusNumber) {
        return lottos.getResult(winningNumbers, bonusNumber);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
