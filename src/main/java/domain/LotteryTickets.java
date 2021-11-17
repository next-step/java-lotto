package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(Store store) {
        this(IssueLotteryTicket(store));
    }

    public LotteryTickets(List<LotteryTicket> lotteryTicket) {
        this.lotteryTickets = Collections.unmodifiableList(lotteryTicket);
    }

    public static List<LotteryTicket> IssueLotteryTicket(Store store) {
        int lotteryCount = store.lotteryCount();

        List<LotteryTicket> lotteryTicket = new ArrayList<>();
        for (int i = 0; i < lotteryCount; i++) {
            lotteryTicket.add(new LotteryTicket(RandomNumber.sixRandomNumber()));
        }

        return lotteryTicket;
    }

    public String lotteryTicketNumber(int index) {
        return lotteryTickets.get(index).lotteryNumber();
    }

    public LotteryTicket lotteryTicket(int index) {
        return lotteryTickets.get(index);
    }

    public int size() {
        return lotteryTickets.size();
    }
}
