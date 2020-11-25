package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lottoes;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoGameResultDto;
import lotto.view.LottoGameView;
import lotto.view.input.InputView;

public class MainSimulator {

    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {

        PurchaseAmount purchaseAmount = new PurchaseAmount(LottoGameView.enterLottoAmount());
        Lottoes lottoes = lottoController.purchaseLottoes(purchaseAmount);
        LottoGameView.printLottoNumbers(lottoes);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers());
        LottoGameResultDto lottoGameResultDto = lottoController.getLottoGameResult(lottoes, winningNumbers);
        LottoGameView.printResult(lottoGameResultDto);

    }
}
