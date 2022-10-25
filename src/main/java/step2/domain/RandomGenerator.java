package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator implements LottoPagersGenerator {
    private final List<Integer> ALL_LOTTO_NUMBER = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    private static final int PICK_NUMBER_COUNT = 6;

    private final LottoPapers lottoPapers;

    public RandomGenerator(int randomLottoPaperCount) {
        lottoPapers = create(randomLottoPaperCount);
    }

    @Override
    public LottoPapers getLottoPapers() {
        return lottoPapers;
    }

    private LottoPapers create(int randomLottoPaperCount) {
        List<LottoPaper> lottoPapers = IntStream.range(0, randomLottoPaperCount)
                .mapToObj(i -> createRandomLottoPaper())
                .collect(Collectors.toList());
        return new LottoPapers(lottoPapers);
    }

    private LottoPaper createRandomLottoPaper() {
        Collections.shuffle(ALL_LOTTO_NUMBER);
        List<Integer> randomLottoPaperInput = ALL_LOTTO_NUMBER.stream()
                .limit(PICK_NUMBER_COUNT)
                .sorted()
                .collect(Collectors.toList());
        return new LottoPaper(randomLottoPaperInput);
    }
}
