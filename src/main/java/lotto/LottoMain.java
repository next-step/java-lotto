package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import static lotto.view.LottoInputView.lastWeeksWinningNumbers;
import static lotto.view.LottoInputView.purchaseAmount;
import static lotto.view.LottoResultView.printLottoResult;
import static lotto.view.LottoResultView.printLottos;

public class LottoMain {
    public static void main(String[] args) {
        Lottos lottos = Lottos.purchase(purchaseAmount());
        printLottos(lottos);

        Lotto winningLotto = Lotto.of(lastWeeksWinningNumbers());
        LottoResult lottoResult = lottos.getLottoResult(winningLotto);
        printLottoResult(lottoResult);
    }
}
