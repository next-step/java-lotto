package lotto.domain.prize;

import lotto.domain.number.Lotto;
import lotto.domain.sales.LottoBundle;

public class WinningReport {

    private final int salesAmount;
    private final LottoBundle lottoBundle;
    private final Lotto winningLotto;
    private WinningPrize winningPrize;

    private WinningReport(int salesAmount, LottoBundle lottoBundle, Lotto winningLotto) {
        this.salesAmount = salesAmount;
        this.lottoBundle = lottoBundle;
        this.winningLotto = winningLotto;
    }

    public static WinningReport of(int salesAmount, LottoBundle lottoBundle, Lotto winningLotto) {
        WinningReport report = new WinningReport(salesAmount, lottoBundle, winningLotto);
        report.analyze();

        return report;
    }

    private void analyze() {
        winningPrize = lottoBundle.winPrize(winningLotto);
    }

    public int winAmount(int match) {
        return winningPrize.winAmount(match);
    }

    public double winningRate() {
        return (double) winningPrize.totalPrize() / salesAmount;
    }
}
