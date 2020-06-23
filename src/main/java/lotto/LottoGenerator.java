package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTERY_SHUFFLE_START_NUMBER = 0;
    private static final int LOTTERY_SHUFFLE_END_NUMBER = 6;
    private static final int LOTTERY_RANDOM_START_NUM = 1;
    private static final int LOTTERY_RANDOM_END_NUM = 46;

    public static Lotto generateAuto() {
        List<Integer> seed = createSeed();
        Collections.shuffle(seed);
        return Lotto.of(new HashSet(seed.subList(LOTTERY_SHUFFLE_START_NUMBER, LOTTERY_SHUFFLE_END_NUMBER)));
    }

    private static List<Integer> createSeed() {
        return IntStream.range(LOTTERY_RANDOM_START_NUM, LOTTERY_RANDOM_END_NUM).boxed().collect(Collectors.toList());
    }

    public static Lottos generateByMoney(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int moneyCount = money.lotteryCount();
        for (int i = 0; i < moneyCount; i++) {
            lottos.add(generateAuto());
        }
        return new Lottos(lottos);
    }
}
