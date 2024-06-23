package lotto.controller;

import lotto.model.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        int payAmount = inputView.inputPayAmount();
        int manualLottoTicketCount = inputView.inputManualLottoTicketCount();

        inputView.printManualLottoNumbers();
        LottoTicketBundle manualLottoTickets = inputView.inputManualLottoNumbers(manualLottoTicketCount);

        int autoLottoTicketCount = (payAmount-(1000*manualLottoTickets.getLottoTickets().size()))/1000;
        LottoTicketBundle autoLottoTickets = LottoTicketBundle.create(autoLottoTicketCount*1000);

        LottoTicketBundle userLottoTickets = new LottoTicketBundle(manualLottoTickets, autoLottoTickets);
        resultView.printLottoTicketCounts(manualLottoTicketCount, autoLottoTicketCount);
        resultView.printUserLottoTickets(userLottoTickets);
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(inputView.inputWinningNumbers()), new LottoNumber(inputView.inputBonusNumber()));
        resultView.printLottoResult(lottoService.calculateResult(userLottoTickets, winningLotto), payAmount);
    }
}
