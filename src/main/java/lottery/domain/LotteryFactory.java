package lottery.domain;

public class LotteryFactory {

    public MatchCountPair matchAll(Lotteries lotteries, WinnerLottery winnerLottery) {
        return lotteries.matchAllAndAddCounts(winnerLottery);
    }
}
