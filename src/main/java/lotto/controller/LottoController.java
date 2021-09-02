package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumberRandomSelector;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int price = inputView.inputPrice();
        LottoGame lottoGame = new LottoGame(price, new LottoNumberRandomSelector());
        outputView.printBasicInfo(lottoGame);

        WinningNumbers winningNumber = new WinningNumbers(inputView.inputLastWinningNumber(),
                                                          inputView.inputBonusNumber());

        LottoResult lottoResult = new LottoResult(lottoGame.checkResult(winningNumber));

        outputView.printResult(lottoResult.getResult());
        outputView.printProfitRatio(lottoResult.getProfitRate(price));
    }
}
