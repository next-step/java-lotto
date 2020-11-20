package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static step2.view.ResultView.TicketAndCount;

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

        List<String> ticketNumbers = lotteryTickets.getTicketNumbers()
                .stream()
                .map(LotteryNumber::toString)
                .collect(toList());
        resultView.responseTicketAndCount(new TicketAndCount.Builder()
                .manualSelectionCount(lotteryTickets.getManualSelectionCount())
                .naturalSelectionCount(lotteryTickets.getNaturalSelectionCount())
                .ticketNumbers(ticketNumbers).build());

        LotteryNumber lastWeekLotteryNumber = LotteryNumber.of(inputView.requestLastWeekLotteryNumber());
        Integer bonusNumber = inputView.requestBonusNumber();
        MatchResult matchResult = new WinningNumber(lastWeekLotteryNumber, bonusNumber).match(lotteryTickets);
        resultView.responseLotteryResult(new ResultView.LotteryResult(matchResult.getRateOfReturn(), matchResult.getAllResult()));
    }
}
