package step2.domain.lotto;

import step2.domain.Money;

import java.util.ArrayList;
import java.util.List;
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

    public void verifyCapacity(Money amount, int rawManualLottoCount) {
        if(normalLottoCapacity(amount)<rawManualLottoCount){
            throw new IllegalArgumentException("돈이 부족합니다");
        }
    }

    public int change(Money amount, int rawManualLottoCount) {
        return amount.getAmount()-rawManualLottoCount*NormalLotto.PRICE;
    }

    public LottoList buyManualLotto(List<String> rawLottoList) {
        return new LottoList((ArrayList<String>) rawLottoList);
    }
}
