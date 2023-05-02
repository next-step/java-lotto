package lotto_second;

import lotto_second.domain.LottoTickets;
import lotto_second.domain.LottoWinner;
import lotto_second.service.LottoResult;
import lotto_second.service.LottoService;
import lotto_second.view.InputView;
import lotto_second.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoService lottoService = new LottoService();
        LottoResult lottoResult = new LottoResult();


        String autoPurchaseAmount = inputView.getPurchaseAmount();
        String manualPurchaseAmount = inputView.getManualPurchaseAmount();

        LottoTickets lottoTickets = lottoService.generateTickets(autoPurchaseAmount);
        resultView.printLottoResult(lottoTickets);

        String winningNumbers = inputView.getWinningNumbers();
        String bonusNumber = inputView.getBonusNumber();

        LottoWinner lottoWinner = new LottoWinner(winningNumbers, bonusNumber);
        lottoWinner.numberDuplicateInspection();

        lottoResult.calculateResult(lottoTickets, lottoWinner);
        resultView.printStatistics(lottoResult);
    }
}
