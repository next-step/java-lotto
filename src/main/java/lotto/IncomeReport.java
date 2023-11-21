package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IncomeReport {

    private final int totalPurchasePrice;
    private final int totalPrize;

    public IncomeReport(int totalPurchasePrice, int totalPrize) {
        this.totalPurchasePrice = totalPurchasePrice;
        this.totalPrize = totalPrize;
    }

    public static IncomeReport of(StatisticsReport statisticsReport) {
        return new IncomeReport(getTotalPurchasePrice(statisticsReport), statisticsReport.totalPrize());
    }

    private static int getTotalPurchasePrice(StatisticsReport statisticsReport) {
        return LottoShop.LOTTO_PRICE * statisticsReport.lottoWallet().totalTicketCount();
    }

    public BigDecimal rate() {
        return BigDecimal.valueOf(totalPrize)
            .divide(BigDecimal.valueOf(totalPurchasePrice), 2, RoundingMode.HALF_UP)
            .stripTrailingZeros();
    }
}
