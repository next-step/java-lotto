package lotto.controller;

import lotto.domain.TicketSeller;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        User user = inputView.getUserInput();
        TicketSeller.sellTicketTo(user);

        outputView.printTickets(user);
    }
}
