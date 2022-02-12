package lotto.controller;

import lotto.domain.Ticket;
import lotto.domain.TicketDealer;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Lottos;
import lotto.domain.machine.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        OutputView outputView = new OutputView();

        Ticket ticket = InputView.buyTicket();
        Lottos lottoRepository = TicketDealer.getLottosOf(new RandomLottoGenerator(), ticket.getBuyCount());

        outputView.printPurchaseAmount(ticket);
        outputView.printPurchaseTicket(lottoRepository);

        WinningNumber winningNumber = InputView.makeWinningNumber();

        WinningResult winningResult = new WinningResult(lottoRepository, winningNumber);
        winningResult.calculateYield(ticket.getBuyCash());

        outputView.printWinningResult(winningResult);
    }
}
