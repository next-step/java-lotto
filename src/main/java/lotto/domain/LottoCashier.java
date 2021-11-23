package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCashier {

    private static final int MIN_LOTTO_BUY_PRICE = 1000;

    public List<Lotto> pay(int money) {
        validate(money);

        int lottoCount = calculateCountAvailable(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    private void validate(int money) {
        if (money < MIN_LOTTO_BUY_PRICE) {
            throw new IllegalArgumentException("해당 금액으로는 로또를 사실 수 없습니다.");
        }
    }

    private int calculateCountAvailable(int money) {
        return money / LottoShop.LOTTO_PRICE;
    }

}
