package lotto;

import lotto.domain.*;
import lotto.utils.LottoUtils;
import lotto.view.ResultView;

import static lotto.view.InputView.*;

public class LottoMain {

    public static void main(String[] args) {
        LottoQuantity lottoQuantity = new LottoQuantity(inputAmount());
        lottoQuantity.setManualQuantity(inputManualQuantity());

        LottoGame lottoGame = createUserLottos(lottoQuantity);
        ResultView.printPurchaseQuantity(lottoQuantity.getManualQuantity(), lottoQuantity.getAutoQuantity());
        printUserLottos(lottoGame);

        WinningLotto winningLotto = new WinningLotto(inputLastWinningNumbers(), inputBonusNumber());
        WinningResult winningResult = lottoGame.play(winningLotto);

        ResultView.printMatchStaticsInfo(winningResult.getStaticsList());
        ResultView.printProfitRate(winningResult.calculateProfitRate(lottoQuantity.getPurchaseAmount()));
    }

    private static LottoGame createUserLottos(LottoQuantity lottoQuantity) {
        LottoGame lottoGame = new LottoGame(LottoUtils.extractLottosFromStrings(inputManualLottoNumbers(lottoQuantity.getManualQuantity())));
        lottoGame.addAllLottos(LottoUtils.generateLottos(lottoQuantity.getAutoQuantity()));
        return lottoGame;
    }

    private static void printUserLottos(LottoGame lottoGame) {
        for (Lotto lotto : lottoGame.getLottos()) {
            ResultView.printLotto(lotto);
        }
    }
}
