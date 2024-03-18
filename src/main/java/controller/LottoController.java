package controller;

import java.math.BigDecimal;

import model.BonusNumber;
import model.LottoAmount;
import model.LottoFactory;
import model.LottoResult;
import model.Lottos;
import model.WinningDetails;
import model.WinningNumbers;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        final LottoAmount lottoAmount = new LottoAmount(inputView.inputPurchaseAmount());
        final Lottos lottos = LottoFactory.create(lottoAmount);

        outputView.printLottoPurchaseCount(lottoAmount.calculateLottoPurchaseCount());
        outputView.printPurchaseLottos(lottos.getLottos());

        final WinningNumbers winningNumbers = new WinningNumbers(inputView.inputWinningLottoNumbers());
        final BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
        final LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber);
        final WinningDetails winningDetails = new WinningDetails();
        winningDetails.makeWinningDetails(lottos, lottoResult);
        final BigDecimal profit = winningDetails.calculateProfit(lottoAmount);

        outputView.printWinningStatistics(winningDetails, profit);
    }
}
