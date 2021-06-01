package lottery.domain;

public class LotteryFactory {

    MatchCountPair matchAll(Lotteries lotteries, WinnerLottery winnerLottery) {
        return matchAllAndAddCounts(lotteries, winnerLottery);
    }

    private MatchCountPair matchAllAndAddCounts(Lotteries lotteries, WinnerLottery winnerLottery) {
        MatchCountPair matchCountPair = new MatchCountPair();

        for (Lottery lottery : lotteries.lotteries()) {
            int matchCount = winnerLottery.match(lottery.numbers());
            matchCountPair.addMatchCountPair(MatchCount.valueOf(matchCount));
        }

        return matchCountPair;
    }
}
