package lotto.vo;

import lotto.utils.Const;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryNumbers {
    Map<Rank, Integer> ranks;
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

    public Map<Rank, Integer> getRank(LotteryNumber winningNumber) {
        ranks = new HashMap<>();
        for (LotteryNumber lottery : lotteryNumbers) {
            Rank rank = getRank(winningNumber, lottery);
            ranks.put(rank, getRanks(rank));
        }
        return ranks;
    }

    private Rank getRank(LotteryNumber winningNumber, LotteryNumber lottery) {
        return winningNumber.match(lottery);
    }

    private int getRanks(Rank rank) {
        return !ranks.containsKey(rank) ? Const.ADD_NUMBER : ranks.get(rank) + Const.ADD_NUMBER;
    }
}
