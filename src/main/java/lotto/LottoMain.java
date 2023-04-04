package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {

        int buyMoney = InputView.inputBuyPrice();
        LottoGame lottoGame = new LottoGame(new Money(buyMoney));

        int manualQuantity = InputView.issueLottos();
        lottoGame.validAvailableGenerate(manualQuantity);

        InputView.issueLottos(lottoGame, manualQuantity);
        ResultView.printBuyCountForPrint(lottoGame);

        int bonusNumber = InputView.inputLastWeekBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(bonusNumber, InputView.inputLastWeekWinningNumber());
        WinningStatistics statistics =lottoGame.getLottos().getWinningStatics(winningNumbers);

        ResultView.printLottoResult(statistics);
    }
}
