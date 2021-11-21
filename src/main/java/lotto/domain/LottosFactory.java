package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottosFactory {
    public static Lottos from(Money money, LottoNumbersGenerator generator) {
        List<Lotto> lottos = Stream.generate(() -> Lotto.from(generator.generate()))
                .limit(money.lottoCount())
                .collect(Collectors.toList());

        return Lottos.from(lottos);
    }
}
