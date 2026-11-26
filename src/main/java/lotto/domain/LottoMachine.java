package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;

    public LottoMachine(int money) {
        if (isMoneyUnderPrice(money)) {
            throw new IllegalArgumentException("구입 금액은 " + LOTTO_PRICE + "원 이상이어야 합니다: " + money);
        }

        this.lottos = new ArrayList<>();
        int numberOfLotto = calculateNumberOfLotto(money);
        for (int i = 0; i < numberOfLotto; i++) {
            this.lottos.add(Lotto.create());
        }
    }

    public LottoResult resultOf(WinningLotto winningLotto) {
        return new LottoResult(lottos, winningLotto, purchaseAmount());
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    private int purchaseAmount() {
        return lottos.size() * LOTTO_PRICE;
    }

    private int calculateNumberOfLotto(int money) {
        return money / LOTTO_PRICE;
    }

    private boolean isMoneyUnderPrice(int money) {
        return money < LOTTO_PRICE;
    }
}
