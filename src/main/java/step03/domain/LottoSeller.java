package step03.domain;

import exception.LackOfMoneyException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    public static final int PRICE_OF_LOTTO = 1000;

    public static Lottos generateLottos(Integer payment) {
        validatePayment(payment);
        int countOfLottos = calculateCountOfLottos(payment);

        List<Lotto> lottos = Stream.iterate(0, n -> n + 1)
                .limit(countOfLottos)
                .map(key -> LottoGenerator.generate())
                .collect(Collectors.toList());

        return Lottos.of(lottos);
    }

    private static int calculateCountOfLottos(int payment) {
        return payment / PRICE_OF_LOTTO;
    }

    private static void validatePayment(Integer payment) {
        if (payment < PRICE_OF_LOTTO) {
            throw new LackOfMoneyException();
        }
    }

}
