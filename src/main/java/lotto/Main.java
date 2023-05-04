package lotto;

import lotto.model.LotteryTicket;
import lotto.view.BroadCast;
import lotto.view.Cashier;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LotteryTicket> lotteryTickets = LotteryStore.sell(Cashier.getMoney());
        Cashier.sayLotteryCount(lotteryTickets.size());
        Cashier.showLotteryTickets(lotteryTickets);
        List<Integer> winNumbers = BroadCast.pickNumbers();

    }
}
