package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.TicketSeller;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private static final String GENERAL_EXCEPTION_MESSAGE = "잘못된 형식의 입력을 입력하셨습니다.";

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

        outputView.printTickets(user);
        LottoResult lastWeekLottoResult = inputView.getLastWeekLottoResult();

        TicketSeller.verifyRankFor(user, lastWeekLottoResult);
    }
}
