package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Main {

    public static void main(String [] args) {
        LottoWallet lottoWallet = InputView.inputMoneyAndManualNumbers();

        LottoSet lottoSet = LottoShop.buy(lottoWallet);
        ResultView.printLottoSet(lottoSet);

        List<LottoNo> winningNumbers = InputView.inputWinningNumbers();
        LottoNo bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = WinningLotto.create(winningNumbers, bonusNumber);

        LottoMachine lottoMachine = new LottoMachine(lottoSet, winningLotto);
        LottoResultSet lottoResultSet = lottoMachine.createLottoResultSet();

        ResultView.printLottoResultSet(lottoResultSet);
        ResultView.printRateReturn(lottoWallet.rateReturn(lottoResultSet.reward()));
    }
}
