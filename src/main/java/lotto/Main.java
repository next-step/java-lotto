package lotto;

import lotto.model.AutoLotteryNumberGenerator;
import lotto.model.LotteryTickets;
import lotto.model.ManualLotteryNumberGenerator;
import lotto.model.Win;
import lotto.model.WinNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int money = InputView.getMoney();

        final int manualLotteryTicketCount = InputView.getManualLotteryTicketCount();
        String ticketNumberString = InputView.enterManualLotteryNumbers();
        LotteryTickets manualLotteryTickets = LotteryTickets.fromCount(manualLotteryTicketCount, ManualLotteryNumberGenerator.from(ticketNumberString));

        LotteryTickets autoLotteryTickets = LotteryTickets.fromMoney(money, manualLotteryTicketCount, new AutoLotteryNumberGenerator());

        OutputView.showLotteryCount(manualLotteryTickets.size(), autoLotteryTickets.size());
        OutputView.showLotteryTickets(manualLotteryTickets, autoLotteryTickets);

        final Set<Integer> winNumbers = InputView.pickWinNumbers();
        final int bonusNumber = InputView.pickBonusNumber();
        final Map<Win, Integer> totalWin = manualLotteryTickets.addAll(autoLotteryTickets)
                .getTotalWin(new WinNumbers(winNumbers, bonusNumber));
        OutputView.showResults(totalWin, money);
    }

}
