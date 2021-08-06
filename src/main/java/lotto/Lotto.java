package lotto;

import java.util.Set;

public class Lotto {
    private final Set<Integer> lottoNums;
    private final NumberGenerator numberGenerator;

    public Lotto(NumberGenerator numberGenerator) {
        this.numberGenerator  = numberGenerator;
        this.lottoNums = createRandomNums();
        sortLottoNums();
    }

    private Set<Integer> createRandomNums() {
        return numberGenerator.generateNumber();
    }

    private void sortLottoNums() {
        lottoNums.stream().sorted();
    }

    public Set<Integer> getLottoNums() {
        return lottoNums;
    }
}
