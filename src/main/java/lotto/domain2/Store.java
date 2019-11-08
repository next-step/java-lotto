package lotto.domain2;

import java.util.Objects;

public class Store {
    private static final int LOTTO_PRICE = 1000;
    private final LottoMachine lottoMachine;

    public Store(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public Lottos issueLotto(final int money) {
        final int countOfLotto = money / LOTTO_PRICE;
        if (countOfLotto == 0) {
            throw new IllegalArgumentException(String.format("로또 하나의 구매 가격은 %s원 입니다.", LOTTO_PRICE));
        }

        return lottoMachine.issue(countOfLotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(lottoMachine, store.lottoMachine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoMachine);
    }
}
