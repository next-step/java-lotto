package lottery.service;

import lottery.code.WinPrizeType;
import lottery.domain.Lotteries;
import lottery.domain.WinLottery;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class LotteryDrawer {

    private final Lotteries lotteries;

    private final WinLottery winLottery;

    public LotteryDrawer(Lotteries lotteries,
                         WinLottery winLottery) {
        this.lotteries = lotteries;
        this.winLottery = winLottery;
    }

    public Map<WinPrizeType, Long> winStatistics() {
        return lotteries.winStatistics(winLottery);
    }

    public BigDecimal profitRate() {
        BigDecimal spent = BigDecimal.valueOf(lotteries.lotteriesTotalPrice());
        BigDecimal profit = BigDecimal.valueOf(lotteries.lotteriesTotalPrize(winStatistics()));
        return profit.divide(spent, 2, RoundingMode.DOWN);
    }
}
