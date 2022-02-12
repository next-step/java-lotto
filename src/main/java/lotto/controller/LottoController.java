package lotto.controller;

import lotto.domain.Ticket;
import lotto.domain.TicketDealer;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.domain.lotto.LottoRepository;
import lotto.domain.machine.RandomLottoGenerator;
import lotto.domain.rank.RankRepository;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        OutputView outputView = new OutputView();

        Ticket ticket = InputView.buyTicket();
        LottoRepository lottoRepository = TicketDealer.getLottosOf(new RandomLottoGenerator(), ticket.getBuyCount());

        outputView.printPurchaseAmount(ticket);
        outputView.printPurchaseTicket(lottoRepository);

        WinningNumber winningNumber = InputView.makeWinningNumber();

        RankRepository rankRepository = RankRepository.getRanksOf(lottoRepository, winningNumber);

        WinningResult winningResult = new WinningResult(rankRepository);
        winningResult.calculateYield(ticket.getBuyCash());

        outputView.printWinningResult(winningResult);
    }
}
