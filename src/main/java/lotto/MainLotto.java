package lotto;

import lotto.domain.*;
import lotto.ui.LottoInputHandler;
import lotto.ui.LottoOutputHandler;

public class MainLotto {
    static LottoInputHandler input = new LottoInputHandler();
    static LottoOutputHandler output = new LottoOutputHandler();
    static LottoGame game = new LottoGame();

    public static void main(String[] args) {
        LottoPurchaseBudget purchaseBudget = input.scanLottoPurchaseBudget();
        output.printCount(purchaseBudget.countOfAvailableLotto());

        Lottos lottos = game.buyLottos(purchaseBudget.countOfAvailableLotto());
        output.printBought(lottos);

        String normalNumbers  = input.scanLottoWinNumbersString();
        int bonusNumber = input.scanLottoBonusNumber();
        LottoWinNumbers winNumbers = new LottoWinNumbers(normalNumbers, bonusNumber);

        LottoResultPack resultPack = winNumbers.checkAllOf(lottos);

        output.printWinnerStatistics(resultPack);
        output.printProfitRatio(resultPack.calculateProfitRatio(purchaseBudget));
    }

}
