package step3;

import step3.domain.Lottos;
import step3.domain.LottosTotalResult;

import java.util.List;

public class LottoGame {
    private Lottos lottos;

    public void generateLottos(int purchaseAmount) {
        lottos = new Lottos(purchaseAmount);
    }

    public LottosTotalResult getTotalResult(List<Integer> winningNumbers) {
        return lottos.getResult(winningNumbers);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
