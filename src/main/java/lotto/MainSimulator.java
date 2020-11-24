package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lottoes;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;
import lotto.dto.LottoGameResultDto;
import lotto.view.LottoGameView;
import lotto.view.input.InputView;

public class MainSimulator {

    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {

        PurchaseAmount purchaseAmount = new PurchaseAmount(LottoGameView.enterLottoAmount());
        Lottoes lottoes = lottoController.purchaseLottoes(purchaseAmount);
        LottoGameView.printLottoNumbers(lottoes);

        WinningNumber winningNumber = new WinningNumber(InputView.enterWinningNumbers());
        LottoGameResultDto lottoGameResultDto = lottoController.getLottoGameResult(lottoes, winningNumber);
        LottoGameView.printResult(lottoGameResultDto);

    }
}
