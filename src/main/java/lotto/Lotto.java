package lotto;

import java.util.Set;

public class Lotto {
    private final Set<Integer> lottoNums;
    private final NumberGenerator numberGenerator;

    public Lotto(NumberGenerator numberGenerator) {
        this.numberGenerator  = numberGenerator;
        this.lottoNums = createRandomNums();
    }

    private Set<Integer> createRandomNums() {
        return numberGenerator.generateNumber();
    }
}
