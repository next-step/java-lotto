package step2;

public class LottoProfit {

    public double profit(int ticketMoney, LottoResult lottoResult) {
        return totalPrize(lottoResult) / ticketMoney;
    }

    private double totalPrize(LottoResult lottoResult) {

        double firstPrize = LottoRank.FIRST.reward()*lottoResult.countOfMatch(LottoRank.FIRST.countOfMatch());
        double secondPrize = LottoRank.SECOND.reward()*lottoResult.countOfMatch(LottoRank.SECOND.countOfMatch());
        double thirdPrize = LottoRank.THIRD.reward()*lottoResult.countOfMatch(LottoRank.THIRD.countOfMatch());
        double fourthPrize = LottoRank.FOURTH.reward()*lottoResult.countOfMatch(LottoRank.FOURTH.countOfMatch());
        double fifthPrize = LottoRank.FIFTH.reward()*lottoResult.countOfMatch(LottoRank.FIFTH.countOfMatch());

        return (firstPrize + secondPrize + thirdPrize + fourthPrize + fifthPrize);
    }
}
