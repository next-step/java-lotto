package lotto;

import lotto.domain.*;

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
        LottoGame lottoGame = new LottoGame(autoLottoAmount, manualLottoCnt);
        lottoGame.createLottos(manualLottoNumbers);

        printLottoNumbers(lottoGame.getManualLottos());
        printLottoNumbers(lottoGame.getAutoLottos());
        printPurchaseNumber(lottoGame);

        String winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusBall();
        Lotto lotto = new Lotto(winningNumber);
        LottoNumber bonus = LottoNumber.from(bonusNumber);
        RankMap rankMap = lottoGame.getResult(lotto, bonus);
        printWinningResult(rankMap);
        printProfitRate(rankMap, lottoGame.getManualCount() + lottoGame.getAutoCount());
    }
}
