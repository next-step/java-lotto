package lotto;

import lotto.model.LotteryTickets;
import lotto.model.Win;
import lotto.view.BroadCast;
import lotto.view.Cashier;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LotteryTickets lotteryTickets = new LotteryTickets(Cashier.getMoney());
        Cashier.sayLotteryCount(lotteryTickets.size());
        Cashier.showLotteryTickets(lotteryTickets);
        List<Integer> winNumbers = BroadCast.pickNumbers();
        if (winNumbers.size() != 6) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다.");
        }
        Map<Win, Integer> winTotal = lotteryTickets.getWinTotal(winNumbers);
        BroadCast.showResult(winTotal);
        BroadCast.showReturn(winTotal);
    }
}
