package lotto;

import lotto.domain.DefaultLottoService;
import lotto.domain.LottoService;
import lotto.domain.ticket.*;
import lotto.dto.LottoResultDto;
import lotto.view.input.InputView;
import lotto.view.result.ResultView;

import java.util.List;

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
        WinningLotto winningLotto = WinningLotto.of(LottoTicket.of(inputView.getWinningTicket()),
                LottoNumber.of(inputView.getBonusNumber()));

        LottoResultDto lottoResultDto = lottoService.checkWinningAmount(lottoTickets, winningLotto, purchaseAmount);
        resultView.printResult(lottoResultDto);
    }
}
