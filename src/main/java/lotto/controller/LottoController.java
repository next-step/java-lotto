package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public void run() {
        int numberOfTickets = InputView.calculateNumberOfTicketsToBuy();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoTickets lottoTickets = lottoGenerator.generateLottoTickets(numberOfTickets);
        ResultView.printLottoTickets(lottoTickets);
    }
}
