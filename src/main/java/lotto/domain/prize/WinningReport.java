package lotto.domain;

import lotto.constant.Prize;

public class WinningReport {

    private final int salesAmount;
    private final LottoBundle lottoBundle;
    private final Lotto winningLotto;
    private final WinningPrize winningPrize;

    public WinningReport(int salesAmount, LottoBundle lottoBundle, Lotto winningLotto) {
        this.salesAmount = salesAmount;
        this.lottoBundle = lottoBundle;
        this.winningLotto = winningLotto;
        this.winningPrize = new WinningPrize();
    }

    public static WinningReport of(int salesAmount, LottoBundle lottoBundle, Lotto winningLotto) {
        return new WinningReport(salesAmount, lottoBundle, winningLotto);
    }

    public void analyze() {
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
