package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private final static int PRICE = 1000;

    private Money money;

    public LottoSeller(Money money) {
        if (!money.checkPayAble(PRICE)) {
            throw new IllegalArgumentException("money is less than " + PRICE);
        }
        this.money = money;
    }

    public List<Lotto> generateLottos(GeneratorStrategy generatorStrategy) {
        List<Lotto> lottos = new ArrayList<>();

        while (money.checkPayAble(PRICE)) {
            lottos.add(generatorStrategy.generate());
            money = money.pay(PRICE);
        }

        return lottos;
    }
}
