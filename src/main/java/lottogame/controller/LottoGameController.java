package lottogame.controller;

import lottogame.domain.TicketSeller;
import lottogame.domain.lotto.LottoResult;
import lottogame.domain.user.User;
import lottogame.domain.user.UserLottoResult;
import lottogame.view.InputView;
import lottogame.view.LottoNumberConsoleInputStrategy;
import lottogame.view.OutputView;

public class LottoGameController {
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

        buyManualLottoTicket(user);
        buyAutomaticLottoTicket(user);

        user.checkValidTicketBuying();

        printResult(user);
    }

    private void buyManualLottoTicket(User user) {
        user.validateManualTicketCondition(TicketSeller.getTicketPrice());

        if(user.getManualTicketCount() > 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }

        for (int i = 0; i < user.getManualTicketCount(); ++i) {
            TicketSeller.sellManualTicketTo(user, new LottoNumberConsoleInputStrategy(inputView));
        }

        System.out.println();
    }

    private void buyAutomaticLottoTicket(User user) {
        TicketSeller.sellAutomaticTicketTo(user);
    }

    private void printResult(User user) {
        outputView.printTickets(user);
        LottoResult lastWeekLottoResult = new LottoResult(inputView.getLastWeekLottoResult(), inputView.getBonusNumberInput());

        UserLottoResult userLottoResult = TicketSeller.verifyRankFor(user, lastWeekLottoResult);
        outputView.printResult(userLottoResult);
    }
}
