package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTickets {

    private static final int LOTTERY_PRICE = 1000;

    private List<LotteryTicket> tickets;

    public LotteryTickets(int money) {
        List<LotteryTicket> tickets = new ArrayList<>();
        for (int i = 0; i < money / LOTTERY_PRICE; i++) {
            tickets.add(new LotteryTicket());
        }
        this.tickets = Collections.unmodifiableList(tickets);
    }

    public int compare(List<Integer> winNumbers) {
        int winSum = 0;
        for (int i = 0; i < this.size(); i++) {
            int winCount = this.tickets.get(i).compare(winNumbers);
            winSum += winCount;
        }
        return winSum;
    }

    public int size() {
       return this.tickets.size();
    }

    public List<LotteryTicket> getTickets() {
        return tickets;
    }
}
