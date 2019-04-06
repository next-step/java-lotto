package lotto.vo;

import lotto.utils.Const;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryNumbers {
    private List<LotteryNumber> lotteryNumbers;

    public LotteryNumbers(List<LotteryNumber> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public int lotteryNumbersCount() {
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
        Map<Rank, Integer> ranks = getRankIntegerMap();
        for (LotteryNumber currentLottery : lotteryNumbers) {
            Rank resultRank = getRank(winningNumber, currentLottery);
            ranks.put(resultRank, ranks.get(resultRank) + 1);
        }
        return new Ranks(ranks);
    }

    private Map<Rank, Integer> getRankIntegerMap() {
        Map<Rank, Integer> ranks = new HashMap<>();
        ranks.put(Rank.FIRST_PLACE, Const.INITIAL_NUMBER);
        ranks.put(Rank.SECOND_PLACE, Const.INITIAL_NUMBER);
        ranks.put(Rank.THIRD_PLACE, Const.INITIAL_NUMBER);
        ranks.put(Rank.FOURTH_PLACE, Const.INITIAL_NUMBER);
        ranks.put(Rank.FAILURE, Const.INITIAL_NUMBER);
        return ranks;
    }

    private Rank getRank(LotteryNumber winningNumber, LotteryNumber currentLottery) {
        return winningNumber.match(currentLottery);
    }
}
