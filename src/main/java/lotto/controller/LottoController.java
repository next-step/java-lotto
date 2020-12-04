package lotto.controller;

import lotto.domain.LottoCount;
import lotto.domain.Lottoes;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.view.LottoGameView;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public Lottoes purchaseLotto() {

        PurchaseAmount purchaseAmount = new PurchaseAmount(LottoGameView.enterLottoAmount());
        LottoCount lottoCount = new LottoCount(LottoGameView.enterManualLottoCount());
        List<String> manualLotto = LottoGameView.enterManualLottoNumber(lottoCount);

        Lottoes lottoes = new Lottoes(purchaseAmount, manualLotto);

        LottoGameView.printLottoNumbers(lottoes);
        return lottoes;
    }

    public void getLottoGameResult(Lottoes lottoes) {
        WinningNumbers winningNumbers = new WinningNumbers(LottoGameView.enterWinningNumbers(), LottoGameView.enterBonusNumber());
        LottoGameView.printResult(lottoes.getResult(winningNumbers));
    }


}
