package lotto;

import lotto.model.LotteryTicket;

import java.util.ArrayList;
import java.util.List;

public class LotteryStore {

    private static final int LOTTERY_PRICE = 1000;

    public static List<LotteryTicket> sell(int money) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        for (int i = 0; i < money / LOTTERY_PRICE; i++) {
            lotteryTickets.add(new LotteryTicket());
        }
        return lotteryTickets;
    }
}
