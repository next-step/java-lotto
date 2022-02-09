package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.LottoBalls;

public class Lottos {

    private static final int PRICE_OF_LOTTO = 1000;
    private static final String LACK_OF_MONEY_EXCEPTION_MESSAGE = "로또 한장의 구입 가격보다 투입 금액이 적습니다.";

    private final List<Lotto> lottos;

    Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createAutoLottos(final Budget budget) {
        final List<Lotto> lottos = new ArrayList<>();

        final int numberOfLotto = getNumberOfLotto(budget);
        for (int i = 0; i < numberOfLotto; i++) {
            LottoBalls.shuffle();
            lottos.add(new Lotto(createRandomNumbers()));
        }
        return new Lottos(lottos);
    }

    private static int getNumberOfLotto(final Budget budget) {
        validatePossibleToPurchase(budget);
        return budget.getValue() / PRICE_OF_LOTTO;
    }

    private static void validatePossibleToPurchase(Budget budget) {
        if (budget.canNotPurchase(PRICE_OF_LOTTO)) {
            throw new IllegalArgumentException(LACK_OF_MONEY_EXCEPTION_MESSAGE);
        }
    }

    private static Set<LottoNumber> createRandomNumbers() {
        return LottoBalls.createLottoNumber();
    }

    public List<Lotto> get() {
        return this.lottos;
    }
}
