package lotto_auto;

import lotto_auto.domain.LottoTickets;
import lotto_auto.service.LottoResult;
import lotto_auto.service.LottoService;
import lotto_auto.view.InputView;
import lotto_auto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoService lottoService = new LottoService();

        LottoTickets lottoTickets = lottoService.generateTickets(lottoService.ticketCount(inputView.getPurchaseAmount()));
        resultView.printLottoResult(lottoTickets);
        LottoResult lottoResult = new LottoResult(lottoTickets, inputView.getWinningNumbers());
        resultView.printStatistics(lottoResult);
    }
}
