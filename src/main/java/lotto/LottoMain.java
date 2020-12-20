package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

import static lotto.view.LottoInputView.lastWeeksWinningNumbers;
import static lotto.view.LottoInputView.purchaseAmount;
import static lotto.view.LottoResultView.printLottoResult;
import static lotto.view.LottoResultView.printLottos;

public class LottoMain {
    public static void main(String[] args) {
        Lottos lottos = Lottos.purchase(purchaseAmount());
        printLottos(lottos);

        WinningLotto winningLotto = new WinningLotto(Lotto.of(lastWeeksWinningNumbers()));
        LottoResult lottoResult = lottos.getLottoResult(winningLotto);
        printLottoResult(lottoResult);
    }
}
