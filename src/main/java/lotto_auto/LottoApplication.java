package lotto_auto;

import lotto_auto.domain.LottoTickets;
import lotto_auto.domain.LottoWinner;
import lotto_auto.service.LottoResult;
import lotto_auto.service.LottoService;
import lotto_auto.view.InputView;
import lotto_auto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoService lottoService = new LottoService();
        LottoResult lottoResult = new LottoResult();

        LottoTickets lottoTickets = lottoService.generateTickets(inputView.getPurchaseAmount());
        resultView.printLottoResult(lottoTickets);
        LottoWinner lottoWinner = new LottoWinner(inputView.getWinningNumbers());
        lottoResult.calculateResult(lottoTickets, lottoWinner);
        resultView.printStatistics(lottoResult, lottoTickets);
    }
}
