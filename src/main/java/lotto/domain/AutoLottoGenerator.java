package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {
    private final Money money;

    public AutoLottoGenerator(int number) {
        this(new Money(number));
    }

    public AutoLottoGenerator(Money money) {
        this.money = money;
    }

    @Override
    public List<Lotto> generate() {
        int cnt = money.getBuyableCount();

        List<Lotto> lottoArray = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            lottoArray.add(new Lotto(LottoMachine.createLottoNumbers()));
        }

        return lottoArray;
    }
}
