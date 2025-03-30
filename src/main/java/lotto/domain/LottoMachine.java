package lotto.domain;

import java.util.List;

import lotto.exception.LottoPriceException;
import lotto.service.LottoFactoryService;
import lotto.strategy.LottoGenerationStrategy;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public LottoMachine(int money) {
        validation(money);
        this.money = money;
    }

    private void validation(int money) {
        if (money < LOTTO_PRICE) {
            throw new LottoPriceException("로또 구매금액은 최소 1000원 이상이어야 합니다.");
        }

        if (money % LOTTO_PRICE != 0) {
            throw new LottoPriceException("로또 구매금액은 1000원 단위로 가능합니다.");
        }
    }

    public List<Lotto> getLottos(LottoGenerationStrategy strategy) {
        return new LottoFactoryService(strategy).createLottos(getLottoCount());
    }

    private int getLottoCount() {
        return money / LOTTO_PRICE;
    }
}
