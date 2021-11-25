package lotto.domain;

import lotto.domain.numbergenerator.AbstractNumberGenerator;
import lotto.domain.numbergenerator.ManualLottoNumbersGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottosFactory {
    public static Lottos from(Money money, AbstractNumberGenerator generator) {
        List<Lotto> lottos = Stream.generate(() -> Lotto.from(generator.generate()))
                .limit(money.lottoCount())
                .collect(Collectors.toList());

        return Lottos.from(lottos);
    }

    public static Lottos from(ManualLottoNumbersGenerator generator) {
        return Lottos.from(Collections.singletonList(Lotto.from(generator.generate())));
    }
}
