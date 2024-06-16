package lotto.controller;

import lotto.model.LottoGame;
import lotto.model.LottoTicket;
import lotto.model.LottoTicketBundle;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoManager {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        int payAmount = inputView.inputPayAmount();
        int manualLottoTicketCount = inputView.inputManualLottoTicketCount();

        inputView.printManualLottoNumbers();
        LottoTicketBundle manualLottoTickets = new LottoTicketBundle(
                IntStream.range(0, manualLottoTicketCount)
                .mapToObj(i -> new LottoTicket(inputView.inputManualLottoNumbers()))
                .collect(Collectors.toList())
        );

        int autoLottoTicketCount = (payAmount-(1000*manualLottoTickets.getLottoTickets().size()))/1000;

        LottoGame lottoGame = new LottoGame(manualLottoTickets, LottoTicketBundle.create(autoLottoTicketCount*1000));

        resultView.printLottoTicketCounts(manualLottoTicketCount, autoLottoTicketCount);
        resultView.printUserLottoTickets(lottoGame);
    }
}
