package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Main {

    public static void main(String [] args) {
        int amount = InputView.inputPurchaseAmount();

        LottoSet lottoSet = LottoShop.buy(amount);
        ResultView.printLottoSet(lottoSet);

        List<LottoNo> winningNumbers = InputView.inputWinningNumbers();
        LottoNo bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = WinningLotto.create(winningNumbers, bonusNumber);

        LottoMachine lottoMachine = new LottoMachine(lottoSet, winningLotto);
        LottoResultSet lottoResultSet = lottoMachine.createLottoResultSet();

        ResultView.printLottoResultSet(lottoResultSet);
        ResultView.printRateReturn(lottoResultSet.rateReturn(amount));
    }
}
