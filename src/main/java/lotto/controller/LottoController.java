package lotto.controller;

import java.util.List;
import lotto.domain.Ticket;
import lotto.domain.TicketDealer;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.machine.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        OutputView outputView = new OutputView();

        Ticket ticket = InputView.buyTicket();

        List<Lotto> manualLottos = InputView.buyManualLotto(ticket.getBuyTotalCount());
        int manualLottosSize = manualLottos.size();
        Lottos lottos = TicketDealer.getLottosByManual(manualLottos);

        int autoLottosSize = ticket.getBuyTotalCount() - manualLottos.size();
        List<Lotto> autoLottos = TicketDealer.getLottosByAuto(lottos, new RandomLottoGenerator(), autoLottosSize);
        lottos.appendLottos(autoLottos);

        ticket.detailCount(manualLottosSize, autoLottosSize);

        outputView.printPurchaseAmount(ticket);
        outputView.printPurchaseTicket(lottos);

        WinningNumber winningNumber = InputView.makeWinningNumber();
        WinningResult winningResult = new WinningResult(lottos, winningNumber);
        winningResult.calculateYield(ticket.getBuyCash());

        outputView.printWinningResult(winningResult);
    }
}
