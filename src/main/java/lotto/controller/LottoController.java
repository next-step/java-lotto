package lotto.controller;

import lotto.constant.Lotto;
import lotto.domain.*;
import lotto.dto.LottoGameResultDto;
import lotto.utils.LottoNumberGenerator;
import lotto.view.LottoGameView;
import lotto.view.input.InputView;

public class LottoController {

    public Lottoes purchaseLottoes() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(LottoGameView.enterLottoAmount());
        Lottoes lottoes = LottoNumberGenerator.create(purchaseAmount);
        LottoGameView.printLottoNumbers(lottoes);
        return lottoes;
    }

    public void getLottoGameResult(Lottoes lottoes) {
        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers());
        LottoGame lottoGame = new LottoGame(lottoes, winningNumbers);
        LottoGameResultDto lottoGameResultDto = new LottoGameResultDto(lottoGame.getResult(), new PurchaseAmount(Lotto.PRICE * lottoes.getValue().size()));
        LottoGameView.printResult(lottoGameResultDto);
    }
}
