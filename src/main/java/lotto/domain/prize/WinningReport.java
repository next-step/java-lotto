package lotto.domain.prize;

import lotto.constant.Prize;
import lotto.domain.number.Lotto;
import lotto.domain.sales.LottoBundle;

public class WinningReport {

    private final int salesAmount;
    private final LottoBundle lottoBundle;
    private final Lotto winningLotto;
    private final WinningPrize winningPrize;

    private WinningReport(int salesAmount, LottoBundle lottoBundle, Lotto winningLotto) {
        this.salesAmount = salesAmount;
        this.lottoBundle = lottoBundle;
        this.winningLotto = winningLotto;
        this.winningPrize = new WinningPrize();
    }

    public static WinningReport of(int salesAmount, LottoBundle lottoBundle, Lotto winningLotto) {
        WinningReport report = new WinningReport(salesAmount, lottoBundle, winningLotto);
        report.analyze();

        return report;
    }

    private void analyze() {
        for (int i = 0; i < lottoBundle.count(); i++) {
            int match = winningLotto.match(lottoBundle.lotto(i));
            Prize prize = Prize.getPrize(match);
            addIf(prize);
        }
    }

    private void addIf(Prize prize) {
        if (prize != null) {
            winningPrize.add(prize);
        }
    }

    public int winAmount(Prize prize) {
        return winningPrize.winAmount(prize);
    }

    public int first() {
        return winningPrize.winAmount(Prize.FIRST);
    }

    public int second() {
        return winningPrize.winAmount(Prize.SECOND);
    }

    public int third() {
        return winningPrize.winAmount(Prize.THIRD);
    }

    public int fourth() {
        return winningPrize.winAmount(Prize.FOURTH);
    }

    public double winningRate() {
        return (double) winningPrize.totalPrize() / salesAmount;
    }
}
