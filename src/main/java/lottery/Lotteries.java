package lottery;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

    public static final int START_INDEX = 0;

    private final ImmutableList<Lottery> lotteries;

    public Lotteries(GenerateCount count, NumberGenerator generator) {
        lotteries = ImmutableList.copyOf(generateLotteries(count, generator));
    }

    private List<Lottery> generateLotteries(GenerateCount generateCount, NumberGenerator generator) {
        List<Lottery> lotteries = new ArrayList<>();

        for (int index = START_INDEX; index < generateCount.count(); index++) {
            lotteries.add(new Lottery(new LotteryNumbers(generator.generate())));
        }

        return lotteries;
    }

    public int size() {
        return lotteries.size();
    }
}
