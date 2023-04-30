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

        LottoTickets lottoTickets = lottoService.generateTickets(inputView.getPurchaseAmount());
        resultView.printLottoResult(lottoTickets);
        LottoWinner lottoWinner = new LottoWinner(inputView.getWinningNumbers(), inputView.getBonusNumber());
        lottoResult.calculateResult(lottoTickets, lottoWinner);
        resultView.printStatistics(lottoResult);
    }
}
