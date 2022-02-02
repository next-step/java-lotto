package lotto.controller;

import lotto.domain.Ticket;
import lotto.domain.lotto.LottoManager;
import lotto.domain.machine.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public LottoController() {

    }

    public void start() {
        Ticket ticket = buyTicket();

        LottoManager lottoManager = new LottoManager(new RandomLottoGenerator(),
            ticket.getBuyCount());

        OutputView.printPurchaseAmount(ticket.getBuyCount());
        OutputView.printPurchaseTicket(lottoManager.getLottos());

        String[] numbers = InputView.writeWinningNumbers();
        String bonus = InputView.writeBonusBall();
    }

    public Ticket buyTicket() {
        int money = Integer.parseInt(InputView.writePurchaseAmount());
        return new Ticket(money);
    }
}
