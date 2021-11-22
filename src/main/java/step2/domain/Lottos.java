package step2.domain;

import step2.strategy.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos = new ArrayList<>();

    private Lottos(int generateCount, NumberGeneratorStrategy generatorStrategy) {
        while (lottos.size() < generateCount) {
            this.lottos.add(Lotto.generate(generatorStrategy));
        }
    }

    public static Lottos purchase(int price, NumberGeneratorStrategy generatorStrategy ) {
        return new Lottos(price / LOTTO_PRICE, generatorStrategy);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottosSize() {
        return lottos.size();
    }
}
