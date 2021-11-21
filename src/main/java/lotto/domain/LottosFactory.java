package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottosFactory {
    private static final int LOTTO_PRICE = 1000;

    //FIXME money = 0 일경우 유효성 검증
    public static Lottos from(int money, LottoNumbersGenerator generator) {
        List<Lotto> lottos = Stream.generate(() -> Lotto.from(generator.generate()))
                .limit(money / LOTTO_PRICE)
                .collect(Collectors.toList());

        return Lottos.from(lottos);
    }
}
