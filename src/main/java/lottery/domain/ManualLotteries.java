package lottery.domain;

import java.util.List;

public class ManualLotteries {

    public static final int MINIMUM_COUNT = 0;

    private final List<LotteryNumbers> manualLotteries;

    public ManualLotteries(List<LotteryNumbers> manualLotteries) {
        this.manualLotteries = manualLotteries;
    }

    public int size() {
        return manualLotteries.size();
    }
}
