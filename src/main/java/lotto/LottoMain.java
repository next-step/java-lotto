package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.view.ResultView;

import static lotto.view.InputView.inputAmount;
import static lotto.view.InputView.inputLastWinningNumbers;

public class LottoMain {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        int lottoQuantity = inputAmount() / LOTTO_PRICE;
        ResultView.printPurchaseQuantity(lottoQuantity);

        LottoGame lottoGame = new LottoGame(lottoQuantity);
        for (Lotto lotto : lottoGame.getLottos()) {
            ResultView.printLotto(lotto);
        }

        WinningLotto winningLotto = new WinningLotto(inputLastWinningNumbers());
        WinningResult winningResult = lottoGame.play(winningLotto);

        ResultView.printMatchStaticsInfo(winningResult.getStaticsList());
        ResultView.printProfitRate(winningResult.calculateProfitRate(), lottoQuantity);
    }
}
