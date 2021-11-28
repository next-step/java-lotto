package lotto.domain;

public class LottoGameResult {
    private final ResultRank resultRank;
    private final int purchaseLottoMoney;

    public LottoGameResult(Lotties lotties, Lotto winLotto) {
        this.resultRank = new ResultRank(lotties.gameResultRank(winLotto));
        this.purchaseLottoMoney = Store.LOTTO_ONE_GAME_PRICE * lotties.purchaseLottiesCount();
    }

    public double getRate() {
        long prizeMoney = resultRank.getPrizeMoney();
        return (double) prizeMoney / this.purchaseLottoMoney;
    }

    public long getRankCount(Rank rank) {
        return this.resultRank.getPrizeCount(rank);
    }


}
