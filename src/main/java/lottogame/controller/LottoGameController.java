package lottogame.controller;

import static java.util.stream.Collectors.*;

import java.util.List;

import lottogame.domain.Money;
import lottogame.domain.TicketSeller;
import lottogame.domain.lotto.LottoNumbers;
import lottogame.domain.lotto.LottoResult;
import lottogame.domain.user.User;
import lottogame.domain.user.UserLottoResult;
import lottogame.view.InputView;
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
        Money money = inputView.getMoneyInput();
        int manualLottoCount = inputView.getManualLottoCount();

        User user = new User(money, manualLottoCount, TicketSeller.getTicketPrice());

        List<LottoNumbers> manualLottoNumbers = inputView.getManualLottoNumbers(manualLottoCount).stream()
            .map(LottoNumbers::valueOf)
            .collect(toList());

        buyAutomaticLottoTicket(user);

        user.checkValidTicketBuying();

        printResult(user);
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
