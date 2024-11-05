package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.inputAmount();
        Lottos lottos = new Lottos(amount);

        int quantity = lottos.getQuantity();
        ResultView.printQuantity(quantity);
        ResultView.printLottos(lottos.getLottoNumbers());

        String lastWinningLottoNumbers = InputView.inputLastWinningLotto();
        Lotto lastWinningLotto = new Lotto(lastWinningLottoNumbers);

        int bonusNumber = InputView.inputBonusNumber();
        LottoResult lottoResult = lottos.getLottoResult(lastWinningLotto, bonusNumber);
        ResultView.printLottoResult(lottoResult, lottos.calculateProfitability(lottoResult, amount));
    }
}
