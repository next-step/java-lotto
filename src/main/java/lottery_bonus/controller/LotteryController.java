package lottery_bonus.controller;

import lottery_bonus.domain.Lotteries;
import lottery_bonus.domain.LotteryMachine;
import lottery_bonus.domain.InputValidation;
import lottery_bonus.domain.WinningResult;
import lottery_bonus.ui.InputView;
import lottery_bonus.ui.ResultView;

import java.math.BigDecimal;
import java.util.List;

public class LotteryController {

    private static final LotteryMachine LOTTERY_MACHINE = LotteryMachine.getInstance();

    public static void main(String[] args) {
        BigDecimal amount = InputValidation.validateAmount(InputView.inputAmount());
        int ticketCount = LOTTERY_MACHINE.purchase(amount);
        Lotteries lotteries = LOTTERY_MACHINE.issue(ticketCount);
        ResultView.print(ticketCount, lotteries);

        List<Integer> winningNumbers = InputValidation.validateWinningNumber(InputView.inputWinningNumber());
        int bonusNumber = InputValidation.parseInteger(InputView.inputBonusNumber());

        WinningResult winningResult = lotteries.drawWinningResult(winningNumbers, bonusNumber);
        ResultView.print(winningResult.getWinningCountList());

        ResultView.print(winningResult, amount);
    }
}
