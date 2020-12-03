package lotto.controller;

import lotto.domain.Lottoes;
import lotto.domain.WinningNumbers;
import lotto.view.LottoGameView;
import lotto.view.input.InputView;

public class LottoController {

    public Lottoes purchaseLotto() {
        Lottoes lottoes = new Lottoes(LottoGameView.enterLottoAmount());
        LottoGameView.printLottoNumbers(lottoes);
        return lottoes;
    }

    public void getLottoGameResult(Lottoes lottoes) {
        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers(), InputView.enterBonusNumber());
        LottoGameView.printResult(lottoes.getResult(winningNumbers));
    }
}
