package lottery.domain;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

    public static final int START_INDEX = 0;

    private final ImmutableList<LotteryNumbers> lotteries;

    public Lotteries(GenerateCount count, NumberGenerator generator) {
        lotteries = ImmutableList.copyOf(generateAutoLotteris(count, generator));
    }

    public Lotteries(GenerateCount auto, NumberGenerator generator, List<LotteryNumbers> manualLotteries) {
        this.lotteries = ImmutableList.copyOf(mergeAutoWithManual(auto, generator, manualLotteries));
    }

    private List<LotteryNumbers> mergeAutoWithManual(
            GenerateCount auto, NumberGenerator generator,
            List<LotteryNumbers> manualLotteries
    ) {
        List<LotteryNumbers> autoLotteryNumbers = generateAutoLotteris(auto, generator);
        autoLotteryNumbers.addAll(manualLotteries);
        return autoLotteryNumbers;
    }

    public MatchCountPair match(WinnerLottery winnerLottery) {
        return new MatchCountPair(winnerLottery, lotteries);
    }

    private List<LotteryNumbers> generateAutoLotteris(GenerateCount generateCount, NumberGenerator generator) {
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
