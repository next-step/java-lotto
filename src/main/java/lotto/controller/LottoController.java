package lotto.controller;

import lotto.domain.*;
import lotto.domain.LottoNumberGenerator;
import lotto.view.LottoGameView;
import lotto.view.input.InputView;

public class LottoController {

    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    public Lottoes purchaseLottoes() {
        Lottoes lottoes = lottoNumberGenerator.create(LottoGameView.enterLottoAmount());
        LottoGameView.printLottoNumbers(lottoes);
        return lottoes;
    }

    public void getLottoGameResult(Lottoes lottoes) {
        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers(), InputView.enterBonusNumber());
        LottoGameView.printResult(lottoes.getResult(winningNumbers));
    }
}
