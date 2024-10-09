package step2.domain;

public class Lotto {
    private LottoNumbers numbers;

    public Lotto(LottoStrategy strategy) {
        this.numbers = strategy.generateLottoNumbers();
    }

}
