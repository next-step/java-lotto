package step2.domain.lotto;

import step2.domain.Money;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public int normalLottoCapacity(Money money) {
        return money.getAmount() / NormalLotto.PRICE;
    }

    public LottoList buyAutoLotto(Money money) {
        int capacity = normalLottoCapacity(money);
        return buyAutoLotto(capacity);
    }

    private LottoList buyAutoLotto(int capacity) {
        return new LottoList(IntStream.range(0, capacity)
                .mapToObj(count -> new NormalLotto())
                .collect(Collectors.toList()));
    }

}
