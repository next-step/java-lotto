package lotto;

import lotto.domain.DefaultLottoService;
import lotto.domain.LottoService;
import lotto.domain.ticket.DefaultLottoTicketGenerator;
import lotto.domain.ticket.LottoTickets;
import lotto.dto.LottoResultDto;
import lotto.view.input.InputView;
import lotto.view.result.ResultView;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoService lottoService;

    private long purchaseAmount;
    private LottoTickets lottoTickets;

    LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoService = new DefaultLottoService(new DefaultLottoTicketGenerator());
    }

    public void run() {
        purchaseLottoTickets();
        checkWinningAmount();
    }

    private void purchaseLottoTickets() {
        purchaseAmount = inputView.getPurchaseAmount();
        lottoTickets = lottoService.purchaseLottoTickets(purchaseAmount);
        resultView.printLottoTickets(lottoTickets);
    }

    private void checkWinningAmount() {
        LottoResultDto lottoResultDto = lottoService.checkWinnintAmount(lottoTickets, inputView.getWinningTicket(), purchaseAmount);
        resultView.printResult(lottoResultDto);
    }
}
