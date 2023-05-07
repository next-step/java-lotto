package lotto;

import lotto.model.LotteryTickets;
import lotto.model.Win;
import lotto.model.WinNumbers;
import lotto.view.OutputView;
import lotto.view.InputView;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int money = InputView.getMoney();
        LotteryTickets lotteryTickets = new LotteryTickets(money);
        OutputView.showLotteryCount(lotteryTickets.size());
        OutputView.showLotteryTickets(lotteryTickets);

        final List<Integer> winNumbers = InputView.pickWinNumbers();
        final Map<Win, Integer> winTotal = lotteryTickets.getWinTotal(new WinNumbers(winNumbers));
        OutputView.showResult(winTotal, money);
    }
}
