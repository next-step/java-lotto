package lotto;

import lotto.domain.DefaultLottoService;
import lotto.domain.LottoService;
import lotto.domain.ticket.*;
import lotto.dto.LottoPurchaseRequestDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoWinningRequestDto;
import lotto.view.input.InputView;
import lotto.view.result.ResultView;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoService lottoService;

    LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoService = new DefaultLottoService(new DefaultLottoTicketGenerator());
    }

    public void run() {
        LottoPurchaseRequestDto lottoPurchaseRequestDto = LottoPurchaseRequestDto.of(inputView.getPurchaseAmount(), inputView.getManualTicketNumbers());
        LottoTickets purchaseTickets = lottoService.purchaseLottoTickets(lottoPurchaseRequestDto);
        resultView.printLottoTickets(purchaseTickets);

        LottoWinningRequestDto lottoWinningRequestDto = LottoWinningRequestDto.of(inputView.getWinningTicket(), inputView.getBonusNumber(), purchaseTickets);
        LottoResultDto lottoResultDto = lottoService.checkWinningAmount(lottoWinningRequestDto);
        resultView.printResult(lottoResultDto);
    }
}
