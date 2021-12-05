package lotto.model;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto() {
        this(new LottoNumbers());
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return numbers;
    }
}
