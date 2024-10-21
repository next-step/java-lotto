package lotto;

import lotto.domain.*;
import lotto.utils.LottoGenerator;
import lotto.view.ResultView;

import java.util.List;

import static lotto.view.InputView.*;

public class LottoMain {

    public static void main(String[] args) {
        LottoQuantity lottoQuantity = new LottoQuantity(inputAmount());

        String[] manualLottoNumbers = inputManualLottoNumbers(inputManualQuantity());
        List<Lotto> userLottos = LottoGenerator.generatorLottos(manualLottoNumbers, lottoQuantity.getTotalQuantity());

        LottoGame lottoGame = new LottoGame(userLottos);
        ResultView.printPurchaseQuantity(manualLottoNumbers.length, lottoQuantity.getTotalQuantity() - manualLottoNumbers.length);
        printUserLottos(lottoGame);

        WinningLotto winningLotto = new WinningLotto(inputLastWinningNumbers(), inputBonusNumber());
        WinningResult winningResult = lottoGame.play(winningLotto);

        ResultView.printMatchStaticsInfo(winningResult.getStaticsList());
        ResultView.printProfitRate(winningResult.calculateProfitRate(lottoQuantity.getPurchaseAmount()));
    }

    private static void printUserLottos(LottoGame lottoGame) {
        for (Lotto lotto : lottoGame.getLottos()) {
            ResultView.printLotto(lotto);
        }
    }
}
