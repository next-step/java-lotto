package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

class LotteryController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LotteryAgent lotteryAgent;

    public LotteryController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        lotteryAgent = new LotteryAgent();
    }

    public void request() {
        Money money = Money.of(inputView.requestMoney());
        Set<LotteryNumber> manualSelectionNumbers = inputView.requestManualSelectionNumbers() //
                .stream() //
                .map(LotteryNumber::new) //
                .collect(toSet());

        Playslip playslip = new Playslip();
        playslip.setManualSelection(new ManualSelection(manualSelectionNumbers));
        LotteryTickets lotteryTickets = lotteryAgent.exchange(money, playslip).getLotteryTickets();
        resultView.responseTicketAndCount(lotteryTickets);

        LotteryNumber lastWeekLotteryNumber = LotteryNumber.of(inputView.requestLastWeekLotteryNumber());
        Integer bonusNumber = inputView.requestBonusNumber();
        LotteryResult lotteryResult = new WinningNumber(lastWeekLotteryNumber, bonusNumber).match(lotteryTickets);
        resultView.responseLotteryResult(lotteryResult);
    }
}
