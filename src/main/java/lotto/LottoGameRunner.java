package lotto;

import lotto.domain.LottoGameCondition;
import lotto.domain.LottoResults;
import lotto.domain.PurchaseAction;
import lotto.domain.model.LottoGames;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoGameRunner {
  public static void main(String[] args) {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    PurchaseAction purchaseAction = inputView.orderLottoGame();
    LottoGames lottoGames = purchaseAction.purchase();
    outputView.printEntryGames(lottoGames);

    LottoGameCondition lottoGameCondition = inputView.inputLastWeekWinNumber();
    LottoResults lottoResults = lottoGames.confirmPrize(lottoGameCondition);

    outputView.printPrizeStatistics(purchaseAction, lottoResults);
  }
}
