package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {
    private final Money money;

    public AutoLottoGenerator(int money) {
        this(new Money(money));
    }

    public AutoLottoGenerator(Money money) {
        this.money = money;
    }

    @Override
    public List<Lotto> generate() {
        List<Lotto> lottoArray = new ArrayList<>();

        for (int i = 0; i < money.getBuyableCount(); i++) {
            lottoArray.add(new Lotto(LottoMachine.createLottoNumbers()));
        }

        return lottoArray;
    }
}
