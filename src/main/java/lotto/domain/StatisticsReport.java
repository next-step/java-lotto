package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class StatisticsReport {

    private final LottoWallet lottoWallet;

    private StatisticsReport(LottoWallet lottoWallet) {
        this.lottoWallet = lottoWallet;
    }

    public static StatisticsReport of(LottoWallet lottoWallet) {
        return new StatisticsReport(lottoWallet);
    }

    public StatisticsReport report(WinningLotto winningLotto) {
        lottoNumberJudge(winningLotto);
        return this;
    }

    private void lottoNumberJudge(WinningLotto winningLotto) {
        for (int i = 0; i < lottoWallet.totalTicketCount(); i++) {
            Prize.applyPrize(winningLotto, lottoWallet.oneTicket(i));
        }
    }

    public BigDecimal rate() {
        int totalPurchasePrice = LottoShop.LOTTO_PRICE * this.lottoWallet.totalTicketCount();
        return BigDecimal.valueOf(totalPrize())
            .divide(BigDecimal.valueOf(totalPurchasePrice), 2, RoundingMode.HALF_UP)
            .stripTrailingZeros();
    }

    public int totalPrize() {
        return Arrays.stream(Prize.values())
            .mapToInt(prize -> prize.rank().getScore() * prize.price())
            .sum();
    }


}
