package lotto.controller;

import lotto.controller.strategy.GenerateStrategy;
import lotto.domain.Lottos;

public class LottosGenerator {
    private int numOfLottos;
    private GenerateStrategy strategy;

    public LottosGenerator(int numOfLottos, GenerateStrategy strategy) {
        this.numOfLottos = numOfLottos;
        this.strategy = strategy;
    }

    public void setStrategy(GenerateStrategy strategy) {
        this.strategy = strategy;
    }

    public Lottos generateLottos() {
        Lottos lottos = new Lottos();
        for (int i = 0; i < numOfLottos; i++) {
            lottos.add(strategy.generateLotto());
        }
        return lottos;
    }
}
