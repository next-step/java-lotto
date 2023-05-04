package lotto;

import lotto.model.LotteryTickets;
import lotto.model.Win;
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

        List<Integer> winNumbers = InputView.pickWinNumbers();
        if (winNumbers.size() != 6) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다.");
        }
        Map<Win, Integer> winTotal = lotteryTickets.getWinTotal(winNumbers);
        OutputView.showResult(winTotal, money);
    }
}
