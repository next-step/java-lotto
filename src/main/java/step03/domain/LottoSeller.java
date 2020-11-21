package step03.domain;

import exception.LackOfMoneyException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    static final int priceOfLotto = 1000;

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
        return payment / priceOfLotto;
    }

    private static void validatePayment(Integer payment) {
        if (payment < priceOfLotto) {
            throw new LackOfMoneyException();
        }
    }

}
