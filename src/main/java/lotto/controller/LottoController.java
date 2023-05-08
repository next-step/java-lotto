package lotto.controller;

import lotto.domain.LottoAvailableNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        int purchaseAmount = InputView.requestPurchaseAmount();
        int purchaseManualGeneratedLottoCount = InputView.requestPurchaseAmountByManual();

        LottoTicket lottoTicket = InputView.buyAndGenerateLottoNumbers(purchaseAmount, purchaseManualGeneratedLottoCount);
        OutputView.printLottos(lottoTicket);

        String inputWinningNumbers = InputView.inputAndValidateWinningNumbers();
        List<LottoAvailableNumber> winningNumbers = InputView.extractNumbers(inputWinningNumbers);

        LottoAvailableNumber inputBonusNumbers = InputView.inputAndValidateBonusNumbers(winningNumbers);

        LottoResult lottoResult = lottoTicket.calculateResult(winningNumbers, inputBonusNumbers);

        OutputView.printWinningStatistics(purchaseAmount, lottoResult);
    }
}