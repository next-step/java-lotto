package lotto.controller;

import lotto.domain.TicketSeller;
import lotto.domain.User;
import lotto.domain.UserLottoResult;
import lotto.domain.vo.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private static final String GENERAL_EXCEPTION_MESSAGE = "잘못된 형식의 입력을 입력하셨습니다.";
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
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
        } catch (Exception e) {
            outputView.printError(GENERAL_EXCEPTION_MESSAGE);
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
