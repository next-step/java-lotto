package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String args[]) {
        LottoGame lottoGame = new LottoGame(new Money(InputView.getPurchaseAmount()));
        OutputView.printPurchaseLotto(lottoGame.getLottoAmount());
        OutputView.printLottoNumbers(lottoGame.getLottoNumbers());

        String winningNumbers = InputView.getWinningNumbers();
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumbers);
        lottoGame.confirmLottos(winningLottoNumbers);

    }
}
