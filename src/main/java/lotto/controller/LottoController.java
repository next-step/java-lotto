package lotto.controller;

import lotto.domain.*;
import lotto.domain.LottoNumberGenerator;
import lotto.view.LottoGameView;
import lotto.view.input.InputView;

public class LottoController {

    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    public Lottoes purchaseLottoes() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(LottoGameView.enterLottoAmount());
        Lottoes lottoes = lottoNumberGenerator.create(purchaseAmount);
        LottoGameView.printLottoNumbers(lottoes);
        return lottoes;
    }

    public void getLottoGameResult(Lottoes lottoes) {
        LottoNumbers winningNumbers = new LottoNumbers(InputView.enterWinningNumbers());
        LottoGameView.printResult(lottoes.getResult(winningNumbers));
    }
}
