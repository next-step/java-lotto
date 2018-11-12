package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottosGenerator;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottosGenerator {
    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.countOfBuyingLotto(); i++) {
            lottos.add(generateAuto());
        }
        return lottos;
    }

    private static Lotto generateAuto() {
        List<Integer> seed = createSeed();
        Collections.shuffle(seed);
        return Lotto.of(seed.subList(0, 6));
    }

    private static List<Integer> createSeed() {
        return IntStream.range(1, 46).boxed().collect(Collectors.toList());
    }
}
