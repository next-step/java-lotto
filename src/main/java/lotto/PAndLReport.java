package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PAndLReport {

    private final int totalPurchasePrice;
    private final int totalPrize;

    public PAndLReport(int totalPurchasePrice, int totalPrize) {
        this.totalPurchasePrice = totalPurchasePrice;
        this.totalPrize = totalPrize;
    }

    public static PAndLReport of(StatisticsReport statisticsReport) {
        return new PAndLReport(LottoShop.LOTTO_PRICE * statisticsReport.lottoWallet().totalTicketCount()
            , statisticsReport.totalPrize());
    }

    public BigDecimal rate() {
        return BigDecimal.valueOf(totalPrize)
            .divide(BigDecimal.valueOf(totalPurchasePrice), 2, RoundingMode.HALF_UP);
    }
}
