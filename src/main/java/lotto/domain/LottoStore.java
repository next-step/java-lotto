package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;
    public static final String NOT_ENOUGH_MONEY_EXCEPTION_MESSAGE =
        LOTTO_PRICE + "원 이상 있어야 구매할 수 있습니다";

    public static Lottos sellAsMuchAsPossible(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int maxAmount = money / LOTTO_PRICE;
        for (int i = 0; i < maxAmount; i++) {
            Lotto lotto = sell(money);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    private static Lotto sell(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalStateException(NOT_ENOUGH_MONEY_EXCEPTION_MESSAGE);
        }
        return LottoFactory.generate();
    }
}
