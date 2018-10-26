package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static Lottos generateByMoney(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.countOfBuyingLotto(); i++) {
            lottos.add(generateAuto());
        }
        return new Lottos(lottos);
    }

    static Lotto generateAuto() {
        List<Integer> seed = createSeed();
        Collections.shuffle(seed);
        return Lotto.of(new HashSet(seed.subList(0, 6)));
    }

    private static List<Integer> createSeed() {
        return IntStream.range(1, 46).boxed().collect(Collectors.toList());
    }
}
