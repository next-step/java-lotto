package lotto.vo;

import lotto.utils.Const;

import java.util.List;
import java.util.Map;

public class LotteryNumbers {
    private List<LotteryNumber> lotteryNumbers;

    public LotteryNumbers(List<LotteryNumber> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public int getLotteryNumbersCount() {
        return lotteryNumbers.size();
    }

    @Override
    public String toString() {
        StringBuilder lotteryNumberBuilder = new StringBuilder();
        for (LotteryNumber lotteryNumber : lotteryNumbers) {
            lotteryNumberBuilder.append(lotteryNumber).append(Const.FORMAT_ENTER);
        }
        return lotteryNumberBuilder.toString();
    }

    public Ranks getRanks(LotteryNumber winningNumber) {
        Map<Rank, Integer> ranks = Ranks.getRankIntegerMap();
        for (LotteryNumber currentLottery : lotteryNumbers) {
            Rank resultRank = Rank.getRank(winningNumber, currentLottery);
            ranks.put(resultRank, ranks.get(resultRank) + Const.ADD_NUMBER);
        }
        return new Ranks(ranks);
    }
}
