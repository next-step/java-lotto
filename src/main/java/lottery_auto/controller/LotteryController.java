package lottery_auto.controller;

import lottery_auto.domain.InputValidation;
import lottery_auto.domain.Lotteries;
import lottery_auto.domain.LotteryMachine;
import lottery_auto.domain.WinningResult;
import lottery_auto.ui.InputView;
import lottery_auto.ui.ResultView;

import java.math.BigDecimal;

public class LotteryController {
    private static final LotteryMachine LOTTERY_MACHINE = LotteryMachine.getInstance();

    public static void main(String[] args) {
        BigDecimal amount = InputValidation.validateAmount(InputView.inputAmount());

        int ticketCount = LOTTERY_MACHINE.purchase(amount);
        Lotteries lotteries = LOTTERY_MACHINE.issue(ticketCount);
        ResultView.print(ticketCount, lotteries);

        String winningNumbers = InputView.inputWinningNumber();
        WinningResult winningResult = lotteries.countMatchNumber(winningNumbers);
        ResultView.print(winningResult.getWinningCount());

        ResultView.print(winningResult, amount);

    }
}
