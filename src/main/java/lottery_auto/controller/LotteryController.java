package lottery_auto.controller;

import lottery_auto.domain.Lotteries;
import lottery_auto.domain.LotteryMachine;
import lottery_auto.domain.WinningResult;
import lottery_auto.strategy.LotteryStrategy;
import lottery_auto.strategy.LotteryStrategyImpl;
import lottery_auto.strategy.ProfitRateStrategy;
import lottery_auto.strategy.ProfitRateStrategyImpl;
import lottery_auto.ui.InputView;
import lottery_auto.ui.ResultView;

import java.util.List;

public class LotteryController {
    private static final LotteryMachine LOTTERY_MACHINE = LotteryMachine.getInstance();
    private static final LotteryStrategy LOTTO_STRATEGY = new LotteryStrategyImpl();
    private static final ProfitRateStrategy PROFIT_RATE_STRATEGY = new ProfitRateStrategyImpl();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int amount = inputView.getAmount();

        int ticket = LOTTERY_MACHINE.purchase(amount);
        Lotteries lotteries = LOTTERY_MACHINE.issue(ticket);
        resultView.print(ticket, lotteries);

        List<Integer> winningNumbers = LOTTO_STRATEGY.generate();
        resultView.print(winningNumbers);

        WinningResult winningResult = lotteries.count(winningNumbers);
        resultView.print(winningResult);

        double rate = (double) winningResult.sum() / amount;
        resultView.print(PROFIT_RATE_STRATEGY.calculateRate(rate));
    }
}
