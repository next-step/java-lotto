package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.inputAmount();
        Lottos lottos = new Lottos(amount);

        int quantity = lottos.getQuantity();
        ResultView.printQuantity(quantity);
        ResultView.printLottos(lottos.getLottos());

        String lastWinningLottoNumbers = InputView.inputLastWinningLotto();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto lastWinningLotto = new WinningLotto(lastWinningLottoNumbers, bonusNumber);

        LottoResult lottoResult = lottos.getLottoResult(lastWinningLotto);
        ResultView.printLottoResult(lottoResult, lottos.calculateProfitability(lottoResult, amount));
    }
}