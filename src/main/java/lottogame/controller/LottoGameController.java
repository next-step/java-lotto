package lottogame.controller;

import lottogame.domain.TicketSeller;
import lottogame.domain.lotto.LottoResult;
import lottogame.domain.user.User;
import lottogame.domain.user.UserLottoResult;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class LottoGameController {
    private static final String NOT_ENOUGH_MONEY_MESSAGE = "소지 금액이 부족합니다.";

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            doRun();
        } catch (Exception e) {
            outputView.printError(e);
        }
    }

    private void doRun() {
        User user = inputView.getUserInput();
        TicketSeller.sellTicketTo(user);

        if (!user.hasTickets()) {
            outputView.printError(NOT_ENOUGH_MONEY_MESSAGE);
            return;
        }

        outputView.printTickets(user);
        LottoResult lastWeekLottoResult = new LottoResult(inputView.getLastWeekLottoResult());

        UserLottoResult userLottoResult = TicketSeller.verifyRankFor(user, lastWeekLottoResult);
        outputView.printResult(userLottoResult);
    }
}
