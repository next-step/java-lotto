package step4;

import step4.domain.Lottos;
import step4.domain.LottosTotalResult;
import step4.domain.WinningLottoNumbers;

import java.util.List;

public class LottoGame {
    private final Lottos lottos;

    public LottoGame(int purchaseAmount) {
        this.lottos = new Lottos(purchaseAmount);
    }

    public LottosTotalResult getTotalResult(List<Integer> winningNumbers, int bonusNumber) {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);
        return lottos.getResult(winningLottoNumbers);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
