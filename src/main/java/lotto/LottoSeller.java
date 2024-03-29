package lotto;


import java.util.Objects;

public class LottoSeller {
    private static final int PRICE_PER_ONE_LOTTO = 1_000;


    public static Lottos sell(BuyLotto buyLotto) {
        validateMoney(buyLotto);
        return new Lottos(buyLotto.getStrategies());
    }

    private static void validateMoney(BuyLotto buyLotto) {
        if (!Objects.equals(buyLotto.getMoney(), price(buyLotto.getCount()))) {
            throw new IllegalStateException("지불금액 오류");
        }
    }

    public static Money price(int count) {
        assert 0 < count;
        return new Money((long) PRICE_PER_ONE_LOTTO * count);
    }


    public static int availableLottoCount(Money money) {
        return money.divide(PRICE_PER_ONE_LOTTO);
    }
}
