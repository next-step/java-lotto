package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

    private final List<Lottery> lotteries;

    public Lotteries(final int lotteryCount) {
        this.lotteries = new ArrayList<>(lotteryCount);
    }

    public int size() {
        return lotteries.size();
    }
}
