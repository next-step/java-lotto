package lotto.domain;

import java.util.List;

public class LottoShop {
    private static final int MINIMUM_AMOUNT = 1000;
    private static final int LOTTO_PRICE = 1000;
    private final Lottos lottos = new Lottos();

    public List<Lotto> getLottos(int money) {
        if (money < MINIMUM_AMOUNT) {
            throw new NotEnoughLottoPurchaseMoneyException("돈이 부족합니다.");
        }
        int buyCnt = money / LOTTO_PRICE;
        return lottos.generateLottos(buyCnt);
    }
}
