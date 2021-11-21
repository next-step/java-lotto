package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(int lotteryCount) {
        this(IssueLotteryTicket(lotteryCount));
    }

    public LotteryTickets(List<LotteryTicket> lotteryTicket) {
        this.lotteryTickets = Collections.unmodifiableList(lotteryTicket);
    }

    private static List<LotteryTicket> IssueLotteryTicket(int lotteryCount) {
        List<LotteryTicket> lotteryTicket = new ArrayList<>();
        for (int i = 0; i < lotteryCount; i++) {
            lotteryTicket.add(new LotteryTicket(RandomNumber.sixRandomNumber()));
        }

        return lotteryTicket;
    }

    public LotteryTicket lotteryTicket(int index) {
        return lotteryTickets.get(index);
    }

    public int size() {
        return lotteryTickets.size();
    }
}
