package lotto.domain;

import lotto.strategy.ManualNumberGenerateStrategy;
import lotto.strategy.NumberGenerateStrategy;
import lotto.strategy.RandomNumberGenerateStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {

    public static List<Lotto> createLotto(LottoPurchaseMethod lottoPurchaseMethod) {

        List<Lotto> manual = createLotto(lottoPurchaseMethod.getManualCount(), new ManualNumberGenerateStrategy());
        List<Lotto> auto = createLotto(lottoPurchaseMethod.autoCount(), new RandomNumberGenerateStrategy());

        return Stream.concat(manual.stream(), auto.stream())
                .collect(Collectors.toList());
    }

    private static List<Lotto> createLotto(int purchaseCount, NumberGenerateStrategy numberGenerateStrategy) {
        return IntStream.range(0, purchaseCount)
                .mapToObj(index -> new Lotto(numberGenerateStrategy.generateNumbers()))
                .collect(Collectors.toList());
    }

}

