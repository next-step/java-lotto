package study.lotto.domain;

public class LottoResult {
    private WinningLottos winningLottos;
    private Amount investmentAmount;

    public LottoResult(WinningLottos winningLottos,
                       Amount investmentAmount) {
        this.winningLottos = winningLottos;
        this.investmentAmount = investmentAmount;
    }

    public LottoResult(WinningLottos winningLottos,
                       int investmentAmount) {
        this(winningLottos, new Amount(investmentAmount));
    }

    public Lottos getWinningLottos(LottoRank lottoRank) {
        return winningLottos.get(lottoRank);
    }

    public double getRateOfReturn() {
        int prizeTotal = getPrizeTotal();

        return (double) prizeTotal / investmentAmount.getAmount();
    }

    private int getPrizeTotal() {
        int prizeTotal = 0;

        for (LottoRank lottoRank : LottoRank.values()) {
            prizeTotal += this.winningLottos.size(lottoRank) *
                    lottoRank.getPrize();
        }

        return prizeTotal;
    }
}
