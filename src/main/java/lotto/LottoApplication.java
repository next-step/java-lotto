package lotto;

import lotto.domain.*;
import lotto.generator.ManualNumberGenerator;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {

        //input
        int autoLottoAmount = inputAutoPurchaseNumber();
        int manualLottoCnt = inputManualPurchaseNumber();
        List<String> manualLottoNumbers = inputManualLottoNumber(manualLottoCnt);

        //create game
        String winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusBall();
        Lotto winning = new Lotto(new ManualNumberGenerator(winningNumber));
        LottoNumber bonus = LottoNumber.from(bonusNumber);
        WinningLotto winningLotto = new WinningLotto(winning, bonus);

        LottoGame lottoGame = new LottoGame(autoLottoAmount, winningLotto);
        lottoGame.createLottos(manualLottoNumbers);
        printLottoNumbers(lottoGame.getManualLottos());
        printLottoNumbers(lottoGame.getAutoLottos());
        printPurchaseNumber(lottoGame);

        LottoResults lottoResults = new LottoResults();
        lottoResults.getTotalResults(lottoGame);
        printWinningResult(lottoResults);
        printProfitRate(lottoResults, lottoGame.getAutoCount() + manualLottoCnt);
    }
}
