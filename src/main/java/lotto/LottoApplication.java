package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.WinningLottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int countOfLotto = purchaseAmount / 1000;
        Lottos lottos = new Lottos(countOfLotto, new LottoNumbers());
        OutputView.printPurchase(lottos);
        WinningLottos winningLottos = new WinningLottos(InputView.inputWinningNumbers());
    }
}
