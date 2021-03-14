package lottery.domain;

import java.util.List;

public class LotteryTicket {

    private final List<Lottery> lotteryList;

    public LotteryTicket(List<Lottery> lotteryList) {
        this.lotteryList = lotteryList;
    }

    public int size() {
        return lotteryList.size();
    }

}
