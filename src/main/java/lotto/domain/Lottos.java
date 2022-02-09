package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private static final int PRICE_OF_LOTTO = 1000;
    private static final int NUMBER_OF_LOTTO_BALL = 6;

    private final List<Lotto> lottos;

    Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createAutoLottos(final Budget budget) {
        final List<Lotto> lottos = new ArrayList<>();

        final int numberOfLotto = getNumberOfLotto(budget);
        for (int i = 0; i < numberOfLotto; i++) {
            Collections.shuffle(LottoBalls.get());
            lottos.add(new Lotto(createRandomNumbers()));
        }
        return new Lottos(lottos);
    }

    private static int getNumberOfLotto(final Budget budget) {
        return budget.getValue() / PRICE_OF_LOTTO;
    }

    private static List<String> createRandomNumbers() {
        final List<String> numbers = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_LOTTO_BALL; i++) {
            numbers.add(LottoBalls.get().get(i));
        }
        return numbers;
    }

    public List<Lotto> get() {
        return this.lottos;
    }
}
