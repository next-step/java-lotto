package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    /**
     * Lottery를 가지고 있는 일급 컬렉션
     *
     */

    private final List<Lottery> lotteries;

    public Lotteries(final int lotteryCount) {
        this.lotteries = new ArrayList<>(lotteryCount);
        generateLottery(lotteryCount);
    }

    private void generateLottery(int lotteryCount) {
        for (int i = 0; i < lotteryCount; i++) {
            lotteries.add(new Lottery());
        }
    }

    public int size() {
        return lotteries.size();
    }
}
