package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Set;

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
        Money money = inputView.requestMoney();
        Set<LotteryNumber> manualSelectionNumbers = inputView.requestManualSelectionNumbers();
        Playslip playslip = new Playslip();
        playslip.setManualSelection(new ManualSelection(manualSelectionNumbers));
        // TODO Exchanges with playslip
        LotteryTickets lotteryTickets = lotteryAgent.exchange(money).getLotteryTickets();
        // TODO Responses with ExchangeResult
        resultView.responseTicketAndCount(lotteryTickets);

        LotteryNumber lastWeekLotteryNumber = inputView.requestLastWeekLotteryNumber();
        Integer bonusNumber = inputView.requestBonusNumber();
        LotteryResult lotteryResult = new WinningNumber(lastWeekLotteryNumber, bonusNumber).match(lotteryTickets);
        resultView.responseLotteryResult(lotteryResult);
    }
}
