package lotto.domain;

import java.util.*;

public class LottoGame {
    public static final Money LOTTO_PRICE = new Money(1000);
    private final long allLottoQuantity;
    private int generatedQuantity = 0;

    public LottoGame(Money lottoPay) {
        this.allLottoQuantity = lottoPay.division(LOTTO_PRICE).toLong();
    }

    public Lottos generateLotto(LottoGenerator lottoGenerator) {
        Lottos generateLottos = lottoGenerator.generate();
        if (getAvailableQuantity() - generateLottos.size() < 0) {
            throw new IllegalArgumentException("사용한 금액보다 많은 로또를 발급할 수 없습니다.");
        }
        this.generatedQuantity += generateLottos.size();
        return generateLottos;
    }

    public Money getBuyPrice() {
        return LOTTO_PRICE.multiply(this.allLottoQuantity);
    }

    public long getAvailableQuantity() {
        return this.allLottoQuantity - generatedQuantity;
    }

    public void validAvailableGenerate(int quantity) {
        if (this.allLottoQuantity - quantity < 0) {
            throw new IllegalArgumentException("사용한 금액보다 많은 로또를 발급할 수 없습니다.");
        }
    }
}
