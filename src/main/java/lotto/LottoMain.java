package lotto;

import lotto.domain.*;
import lotto.domain.LottoGenerator;
import lotto.view.ResultView;

import java.util.List;

import static lotto.view.InputView.*;

public class LottoMain {

    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator(inputAmount());

        String[] manualLottoNumbers = inputManualLottoNumbers(inputManualQuantity());
        List<Lotto> userLottos = generator.generatorLottos(manualLottoNumbers);

        LottoGame lottoGame = new LottoGame(userLottos);
        ResultView.printPurchaseQuantity(manualLottoNumbers.length, userLottos.size() - manualLottoNumbers.length);
        printUserLottos(lottoGame);

        WinningLotto winningLotto = new WinningLotto(inputLastWinningNumbers(), inputBonusNumber());
        WinningResult winningResult = lottoGame.play(winningLotto);

        ResultView.printMatchStaticsInfo(winningResult.getStaticsList());
        ResultView.printProfitRate(winningResult.calculateProfitRate(generator.getPurchaseAmount()));
    }

    private static void printUserLottos(LottoGame lottoGame) {
        for (Lotto lotto : lottoGame.getLottos()) {
            ResultView.printLotto(lotto);
        }
    }
}
