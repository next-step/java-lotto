package lottery;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

    public static final int START_INDEX = 0;
    public static final int MINIMUM_GENERATE_COUNT = 1;

    private final ImmutableList<Lottery> lotteries;

    public Lotteries(int count, NumberGenerator generator) {
        validateGenerateCount(count);

        lotteries = ImmutableList.copyOf(generateLotteries(count, generator));
    }

    private void validateGenerateCount(int count) {
        if (count < MINIMUM_GENERATE_COUNT) {
            throw new IllegalArgumentException("로또 생성 개수는 1개 이상이어야 합니다.");
        }
    }

    private List<Lottery> generateLotteries(int count, NumberGenerator generator) {
        List<Lottery> lotteries = new ArrayList<>();

        for (int index = START_INDEX; index < count; index++) {
            lotteries.add(new Lottery(new LotteryNumbers(generator.generate())));
        }

        return lotteries;
    }

    public int size() {
        return lotteries.size();
    }
}
