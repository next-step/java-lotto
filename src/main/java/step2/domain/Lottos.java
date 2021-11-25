package step2.domain;

import step2.strategy.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    private Lottos() {
    }

    private Lottos(int generateCount, NumberGeneratorStrategy generatorStrategy) {
        while (lottos.size() < generateCount) {
            this.lottos.add(Lotto.generate(generatorStrategy));
        }
    }

    public static Lottos create() {
        return new Lottos();
    }

    public static Lottos purchase(int generateCount, NumberGeneratorStrategy generatorStrategy) {
        return new Lottos(generateCount, generatorStrategy);
    }

    public void addAll(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
