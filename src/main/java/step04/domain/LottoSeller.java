package step04.domain;

import exception.LackOfMoneyException;

import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoSeller {
    public static final int PRICE_OF_LOTTO = 1000;

    public static Lottos generateLottos(Integer payment) {
        validatePayment(payment);
        int countOfLottos = calculateCountOfLottos(payment);

        return Stream.iterate(0, n -> n + 1)
                .limit(countOfLottos)
                .map(key -> LottoGenerator.generate())
                .collect(collectingAndThen(toList(), Lottos::of));
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
