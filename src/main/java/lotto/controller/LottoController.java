package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        int purchaseAmount = InputView.requestPurchaseAmount();
        LottoTicket lottoTicket = InputView.buyAndGenerateLottoNumbers(purchaseAmount);
        OutputView.printLottos(lottoTicket);

        String inputWinningNumbers = InputView.inputAndValidateWinningNumbers();
        List<Integer> winningNumbers = InputView.extractNumbers(inputWinningNumbers);

        int inputBonusNumbers = InputView.inputAndValidateBonusNumbers(winningNumbers);

        LottoResult lottoResult = lottoTicket.calculateResult(winningNumbers, inputBonusNumbers);

        OutputView.printWinningStatistics(purchaseAmount, lottoResult);
    }
}