package lottery.domain;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

    public static final int START_INDEX = 0;

    private final ImmutableList<LotteryNumbers> lotteries;

    public Lotteries(GenerateCount count, NumberGenerator generator) {
        lotteries = ImmutableList.copyOf(generateLotteries(count, generator));
    }

    public MatchCountPair match(WinnerLottery winnerLottery, int bonusBall) {
        return new MatchCountPair(winnerLottery, lotteries, bonusBall);
    }

    private List<LotteryNumbers> generateLotteries(GenerateCount generateCount, NumberGenerator generator) {
        List<LotteryNumbers> lotteries = new ArrayList<>();

        for (int index = START_INDEX; index < generateCount.count(); index++) {
            lotteries.add(new LotteryNumbers(generator.generate()));
        }

        return lotteries;
    }

    public List<LotteryNumbers> lotteries() {
        return lotteries;
    }

    public int size() {
        return lotteries.size();
    }
}
