package lotto.domain;

import java.util.ArrayList;

public class LottoGame {
    public static final Money LOTTO_PRICE = new Money(1000);
    private final long allLottoQuantity;
    private int generatedQuantity = 0;
    private final Lottos lottos;

    public LottoGame(Money lottoPay) {
        this.lottos = new Lottos(new ArrayList<>());
        this.allLottoQuantity = lottoPay.division(LOTTO_PRICE).toLong();
    }

    public Money getBuyPrice() {
        return LOTTO_PRICE.multiply(this.allLottoQuantity);
    }

    public long getAvailableQuantity() {
        return this.allLottoQuantity - this.generatedQuantity;
    }

    public void validAvailableGenerate(int quantity) {
        if (this.allLottoQuantity - quantity < 0) {
            throw new IllegalArgumentException("사용한 금액보다 많은 로또를 발급할 수 없습니다.");
        }
    }

    public void issueLotto(LottoGenerator lottoGenerator) {
        if (getAvailableQuantity() == 0) {
            throw new IllegalArgumentException("사용한 금액보다 많은 로또를 발급할 수 없습니다.");
        }
        this.generatedQuantity++;
        this.lottos.add(lottoGenerator.generate());
    }

    public Lottos getLottos() {
        return this.lottos;
    }
}
