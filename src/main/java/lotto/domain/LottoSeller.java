package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private final static int PRICE = 1000;

    private int money;

    public LottoSeller(int money) {
        checkMoney(money);
        this.money = money;
    }

    private static void checkMoney(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("money is less than " + PRICE);
        }
    }

    public List<Lotto> generateLottos(GeneratorStrategy generatorStrategy) {
        List<Lotto> lottos = new ArrayList<>();

        while (money / PRICE >= 1) {
            lottos.add(generatorStrategy.generate());
            money -= PRICE;
        }

        return lottos;
    }
}
