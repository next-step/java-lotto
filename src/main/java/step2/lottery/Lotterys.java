package step2.lottery;

import step2.generate.Generate;
import step2.winning.PrizeWinningNumber;
import step2.winning.Winning;
import step2.winning.WinningResults;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lotterys {
    private final List<Lottery> lotteries;
    private static final int LOTTO_LENGTH = 6;
    public Lotterys(int count, Generate generate) {
        lotteries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotteries.add(new Lottery(generate.makeNumbers(LOTTO_LENGTH)));
        }
    }

    public int length() {
        return lotteries.size();
    }

    public Lottery getLottery(int index) {
        return lotteries.get(index);
    }

    public WinningResults countWinningResults(PrizeWinningNumber prize) {
        Map<Winning, Integer> prizeAmounts = new EnumMap<>(Winning.class);
        for (Winning winning : Winning.values()) {
            prizeAmounts.put(winning, 0);
        }

        for (Lottery lottery : lotteries) {
            Winning result = lottery.matchWith(prize);
            prizeAmounts.put(result, prizeAmounts.get(result) + 1);
        }

        return new WinningResults(prizeAmounts);
    }
}
