package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Store {
    private static final int LOTTO_PRICE = 1_000;
    private final LottoMachine lottoMachine;

    public Store(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public Lottos issueLotto(final int money, final List<String> directLottos) {
        final int countOfTotalLotto = money / LOTTO_PRICE;

        if (countOfTotalLotto == 0) {
            throw new IllegalArgumentException(String.format("로또 하나의 구매 가격은 %s원 입니다.", LOTTO_PRICE));
        }

        if (countOfTotalLotto < directLottos.size()) {
            int needfulMoney = directLottos.size() * LOTTO_PRICE;
            throw new IllegalArgumentException(
                    String.format(
                            "원하는 만큼 수동 로또 구매를 위해서는 %s원이 필요합니다. 지불한 금액은 %s원입니다.",
                            needfulMoney,
                            money
                    )
            );
        }

        return lottoMachine.issue(countOfTotalLotto, directLottos);
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
