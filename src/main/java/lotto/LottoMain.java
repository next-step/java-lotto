package lotto;

import lotto.domain.*;
import lotto.view.ResultView;

import static lotto.view.InputView.*;

public class LottoMain {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        LottoQuantity lottoQuantity = new LottoQuantity(inputAmount());
        ResultView.printPurchaseQuantity(lottoQuantity.getTotalQuantity());

        lottoQuantity.setManualQuantity(inputManualQuantity());
        inputManualLottoNumbers(lottoQuantity.getManualQuantity());

        LottoGame lottoGame = new LottoGame(lottoQuantity.getAutoQuantity());
        for (Lotto lotto : lottoGame.getLottos()) {
            ResultView.printLotto(lotto);
        }

        WinningLotto winningLotto = new WinningLotto(inputLastWinningNumbers(), inputBonusNumber());
        WinningResult winningResult = lottoGame.play(winningLotto);

        ResultView.printMatchStaticsInfo(winningResult.getStaticsList());
        ResultView.printProfitRate(winningResult.calculateProfitRate(lottoQuantity.getPurchaseAmount()));
    }
}
