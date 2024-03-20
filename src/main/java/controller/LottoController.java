package controller;

import java.math.BigDecimal;

import model.LottoAmount;
import model.LottoFactory;
import model.LottoNumber;
import model.LottoWinningNumber;
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
        final int numberOfManualLottoNumbers = inputView.inputNumberOfManualLottoNumbers();
        final int numberOfAutomaticLottoNumbers = lottoAmount.calculateAutomaticLottoCount(numberOfManualLottoNumbers);
        final Lottos lottos = LottoFactory.create(numberOfAutomaticLottoNumbers,
                inputView.inputManualLottoNumbers(numberOfManualLottoNumbers));

        outputView.printLottoPurchaseCount(numberOfAutomaticLottoNumbers, numberOfManualLottoNumbers);
        outputView.printPurchaseLottos(lottos.getLottos());

        final WinningNumbers winningNumbers = new WinningNumbers(inputView.inputWinningLottoNumbers());
        final LottoNumber lottoNumber = new LottoNumber(inputView.inputBonusNumber());
        final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers, lottoNumber);
        final WinningDetails winningDetails = new WinningDetails();
        winningDetails.makeWinningDetails(lottos, lottoWinningNumber);
        final BigDecimal profit = winningDetails.calculateProfit(lottoAmount);

        outputView.printWinningStatistics(winningDetails, profit);
    }
}
