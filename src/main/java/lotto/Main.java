package lotto;

import lotto.model.LotteryTickets;
import lotto.model.Win;
import lotto.model.WinNumbers;
import lotto.model.AutoLotteryNumberGenerator;
import lotto.view.OutputView;
import lotto.view.InputView;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int money = InputView.getMoney();
        LotteryTickets lotteryTickets = LotteryTickets.of(money, new AutoLotteryNumberGenerator());
        OutputView.showLotteryCount(lotteryTickets.size());
        OutputView.showLotteryTickets(lotteryTickets);

        final Set<Integer> winNumbers = InputView.pickWinNumbers();
        final int bonusNumber = InputView.pickBonusNumber();
        final Map<Win, Integer> totalWin = lotteryTickets.getTotalWin(new WinNumbers(winNumbers, bonusNumber));
        OutputView.showResults(totalWin, money);
    }
}
